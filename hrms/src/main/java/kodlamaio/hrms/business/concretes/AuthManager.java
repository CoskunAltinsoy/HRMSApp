package kodlamaio.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.Verification.VerificationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;



@Service
public class AuthManager implements AuthService{
	
    private ModelMapper modelMapper;
	private UserService userService;
	private CandidateService candidateService;
    private EmployerService employerService;
    private VerificationService verificationService;
    private VerificationCodeService verificationCodeService;
    
    @Autowired
	public AuthManager(ModelMapper modelMapper, UserService userService, CandidateService candidateService,
			EmployerService employerService, VerificationService verificationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.modelMapper = modelMapper;
		this.userService = userService;
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.verificationService = verificationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result registerForCandidate(RegisterForCandidateDto registerForCandidateDto) {
			
		if (registerForCandidateDto.getEmail() ==null ||
				registerForCandidateDto.getPassword() == null ||
				registerForCandidateDto.getPasswordConfirm() == null){
            return new ErrorResult("Boş alan bırakılmamalıdır.");
        }
        if(checkPasswordConfirm(registerForCandidateDto.getPassword(), registerForCandidateDto.getPasswordConfirm()).isSuccess()
        		&& userService.getByEmail(registerForCandidateDto.getEmail()) != null) {
        	
        	return new ErrorResult();  	
        }
        
        Candidate candidate = modelMapper.map(registerForCandidateDto, Candidate.class);
        this.candidateService.add(candidate);
        this.verificationService.sendVerificationCode(registerForCandidateDto.getEmail());
        String verificationCode = verificationService.codeGenerator();
        User user=this.userService.getByEmail(registerForCandidateDto.getEmail()).getData();
        this.verificationCodeService.add(new VerificationCode(user.getId(), verificationCode, true));
        return new SuccessResult("Aday başarıyla kaydedildi.");
	}

	@Override
	public Result registerForEmployer(RegisterForEmployerDto registerForEmployerDto) {
	
		if(!(checkPasswordConfirm(registerForEmployerDto.getPassword(), registerForEmployerDto.getPasswordConfirm()).isSuccess()
				&& checkNullFields(registerForEmployerDto).isSuccess() 
				&& userService.getByEmail(registerForEmployerDto.getEmail()) != null)) {
			
			return new ErrorResult();
		}	
		
		Employer employer = modelMapper.map(registerForEmployerDto, Employer.class);
	    this.employerService.add(employer);
	    this.verificationService.sendVerificationCode(registerForEmployerDto.getEmail());
        String verificationCode = verificationService.codeGenerator();
        User user=this.userService.getByEmail(registerForEmployerDto.getEmail()).getData();
        this.verificationCodeService.add(new VerificationCode(user.getId(), verificationCode, true));
	    return new SuccessResult("Çalışan başarıyla kaydedildi.");
		
		
		
	}
	
	private Result checkPasswordConfirm(String password, String passwordConfirm) {
		
		if (!password.equals(passwordConfirm)){
            return new ErrorResult("Parola eşleşmedi.");
        }
        return new SuccessResult();
	}
	
	
	private  Result checkNullFields(RegisterForEmployerDto registerForEmployerDto){

        if(registerForEmployerDto.getPassword() == null){
            return new ErrorResult("Parola alanı boş olmamalı.");
        }
        return new SuccessResult();
    }
	
	
	//private Result checkUserExistsByEmail(RegisterForEmployerDto registerForEmployerDto)  {
		//if(userService.getByEmail(registerForEmployerDto.getEmail()) != null) {
			//return new ErrorResult("Bu adres zaten mevcut.");
	//	}
		//return new SuccessResult();
	//}
}
