package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult();
	}

	@Override
	public Result delete(Language language) {
		this.languageDao.delete(language);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(this.languageDao.findById(id));
	}

	@Override
	public DataResult<List<Language>> getByCandidateId(int id) {
		return new SuccessDataResult<List<Language>>(this.languageDao.findByCandidate_id(id));
	}

}
