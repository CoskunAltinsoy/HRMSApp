package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.Verification.VerificationService;
import kodlamaio.hrms.core.utilities.adapters.MernisServiceAdapter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private MernisServiceAdapter mernisServiceAdapter;
	private VerificationService verificationService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisServiceAdapter mernisServiceAdapter,
			VerificationService verificationService, VerificationCodeService verificationCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisServiceAdapter = mernisServiceAdapter;
		this.verificationService = verificationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> get(int id) {
		return null; //new SuccessDataResult<Candidate>(this.candidateDao.findById(id));
	}

	@Override
	public Result add(Candidate candidate) {
		if(!checkNullFields(candidate).isSuccess()) {
			return new ErrorResult();
		}
		
		if(!mernisServiceAdapter.checkIfRealPerson(candidate).isSuccess()) {
			return new ErrorResult();
		}
		
		if(!checkUserNationalIdentity(candidate).isSuccess()) {
			return new ErrorResult();
		}
		this.verifyAccount(candidate);
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday kaydı gerçekleşti."); 
	
	}

	@Override
	public DataResult<Candidate> getByNationalIdentity(String nationalIdentity) {	
		return new SuccessDataResult<Candidate>(candidateDao.findByNationalIdentity(nationalIdentity));
	}

	@Override
	public Result delete(Candidate canidate) {
		candidateDao.delete(canidate);
        return new SuccessResult("Aday Silindi.");
	}

    private Result checkNullFields(Candidate candidate) {
    	if(candidate.getFirstName() == null || candidate.getLastName() == null
    			|| candidate.getNationalIdentity() == null 
    			|| candidate.getDateOfBirth() == null
    			|| candidate.getEmail() == null
    			|| candidate.getPassword() == null) {
    		
       	   return new ErrorResult("Boş alan bırakılmamalıdır.");     		
    	}
    	
    	return new SuccessResult("Boş alan bırakılmamalıdır."); 
    }
	
	private Result checkUserNationalIdentity(Candidate candidate) {
		
		if(candidateDao.findByNationalIdentity(candidate.getNationalIdentity())!=null
				|| candidateDao.findByEmail(candidate.getEmail()) != null){
			new ErrorResult("Kullanılmamış bilgiler giriniz.");
		}
		return new SuccessResult();
	}
	
	private Result verifyAccount(Candidate candidate) {
		
		this.verificationService.sendVerificationCode(candidate.getEmail());
		String verification = this.verificationService.codeGenerator();
		this.verificationCodeService.add(new VerificationCode(candidate.getId(), verification, true));
		return new SuccessResult();		
	}
	

}
