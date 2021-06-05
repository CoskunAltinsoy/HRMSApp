package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	DataResult<List<JobAdvert>> getAll();
	Result add(JobAdvert jobAdvert);
	DataResult<List<JobAdvert>> findAllByStatusTrue();
	DataResult<List<JobAdvert>> findAllByStatusTrueOrderByDeadlineAsc();
    DataResult<List<JobAdvert>> findAllByStatusTrueOrderByPublishedDateDesc();

}
