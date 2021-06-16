package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;



public interface CurriculumVitaeService {
	
	Result add(CurriculumVitae curriculumVitae);
	Result delete(CurriculumVitae curriculumVitae);
	DataResult<List<CurriculumVitae>> getAll();
	DataResult<CurriculumVitae> getById(int id);
	DataResult<List<CurriculumVitae>>  getByCandidateId(int candidateId);

}
