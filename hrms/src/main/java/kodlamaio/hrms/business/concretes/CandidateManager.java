package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.adapters.MernisServiceAdapter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private MernisServiceAdapter mernisServiceAdapter;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisServiceAdapter mernisServiceAdapter) {
		super();
		this.candidateDao = candidateDao;
		this.mernisServiceAdapter = mernisServiceAdapter;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> get(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
	}

	@Override
	public Result add(Candidate candidate) {
		if(checkUserNationalIdentity(candidate).isSuccess() 
				&& mernisServiceAdapter.checkIfRealPerson(candidate).isSuccess()) {
			this.candidateDao.save(candidate);
			return new SuccessResult("İş Adayı Eklendi");
		}
		return new ErrorResult();
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


	private Result checkUserNationalIdentity(Candidate candidate) {
		
		if(getByNationalIdentity(candidate.getNationalIdentity()).getData()!=null){
			new ErrorResult("Başka bir adres yazınız.");
		}
		return new SuccessResult();
	}
	

}
