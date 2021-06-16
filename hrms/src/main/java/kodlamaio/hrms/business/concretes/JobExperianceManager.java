package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperianceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperianceDao;
import kodlamaio.hrms.entities.concretes.JobExperiance;

@Service
public class JobExperianceManager implements JobExperianceService{
	
	private JobExperianceDao jobExperianceDao;

	@Autowired
	public JobExperianceManager(JobExperianceDao jobExperianceDao) {
		super();
		this.jobExperianceDao = jobExperianceDao;
	}

	@Override
	public Result add(JobExperiance jobExperiance) {
		this.jobExperianceDao.save(jobExperiance);
		return new SuccessResult();
	}

	@Override
	public Result delete(JobExperiance jobExperiance) {
		this.jobExperianceDao.delete(jobExperiance);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobExperiance>> getAll() {
		return new SuccessDataResult<List<JobExperiance>>(this.jobExperianceDao.findAll());
	}

	@Override
	public DataResult<JobExperiance> getById(int id) {
		return new SuccessDataResult<JobExperiance>(this.jobExperianceDao.findById(id));
	}

	@Override
	public DataResult<List<JobExperiance>> getAllByCandidateIdOrderByEndOfDate(int id) {
		return new SuccessDataResult<List<JobExperiance>>
		(this.jobExperianceDao.findAllByCandidate_idOrderByEndOfDate(id));
	}

	@Override
	public DataResult<List<JobExperiance>> getByCandidateId(int id) {
		return new SuccessDataResult<List<JobExperiance>>(this.jobExperianceDao.findByCandidate_id(id));
	}

}
