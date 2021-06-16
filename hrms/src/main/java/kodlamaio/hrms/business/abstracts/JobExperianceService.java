package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperiance;

public interface JobExperianceService {
	
	Result add(JobExperiance jobExperiance);
	Result delete(JobExperiance jobExperiance);
	DataResult<List<JobExperiance>> getAll();
	DataResult<JobExperiance> getById(int id);
	DataResult<List<JobExperiance>> getAllByCandidateIdOrderByEndOfDate(int id);
	DataResult<List<JobExperiance>> getByCandidateId(int id);

}
