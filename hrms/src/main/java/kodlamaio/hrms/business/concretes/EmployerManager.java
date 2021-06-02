package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.Verification.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationService verificationService;
	private VerificationCodeService verificationCodeService;
	
    @Autowired
	public EmployerManager(EmployerDao employerDao, VerificationService verificationService, 
			VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.verificationService = verificationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> get(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id).get());
	}

	@Override
	public Result add(Employer employer) {
		if(!checkNullFields(employer).isSuccess()) {
			return new ErrorResult();
		}
		if(!checkUserNationalIdentity(employer).isSuccess()) {
			return new ErrorResult();
		}
		this.verifyAccount(employer);
		this.employerDao.save(employer);
		return new SuccessResult("İşveren Eklendi");
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult();
	}
	
	 private Result checkNullFields(Employer employer) {
		 if(employer.getEmail() == null || employer.getWebAddress() == null
				 || employer.getCompanyName() == null 
	             || employer.getPhoneAddress()== null
	    		 || employer.getPassword() == null) {
	    		
			 return new ErrorResult("Boş alan bırakılmamalıdır.");     		
	    	}
		 if(!checkDomain(employer).isSuccess()) {
			 return new ErrorResult("Emailiniz web adresi ile uyuşmuyor.");  		 
		 }
	    	return new SuccessResult(); 
	    }
	 
	 private Result checkUserNationalIdentity(Employer employer) {
			
			if(employerDao.findByEmail(employer.getEmail()) != null){
				new ErrorResult("Kullanılmamış bilgiler giriniz.");
			}
			return new SuccessResult();
		}
	 
	 private Result verifyAccount(Employer employer) {
		 this.verificationService.sendVerificationCode(employer.getEmail());
		 String verification = this.verificationService.codeGenerator();
		 this.verificationCodeService.add(new VerificationCode(employer.getId(), verification, true));
		 return new SuccessResult();		
		}
	 
	 private Result checkDomain(Employer employer) {
		 String[] isEmailCompatible = employer.getEmail().split("@", 2);
	     String webAddress = employer.getWebAddress().substring(4);
         if (!isEmailCompatible[1].equals(webAddress)){
        	 return new ErrorResult();
	       }
	        return new SuccessResult();
	 }
		
	
   
}
