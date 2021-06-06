package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	
    @Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());	
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Yeni iş ilanı eklendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByStatusTrue() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByStatusTrue());
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByStatusTrueOrderByDeadlineAsc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByStatusTrueOrderByDeadlineAsc());
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByStatusTrueOrderByPublishedDateDesc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByStatusTrueOrderByPublishedDateDesc());
	}

	
}
