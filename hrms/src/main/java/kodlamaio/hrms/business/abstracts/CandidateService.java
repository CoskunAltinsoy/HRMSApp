package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Dtos.CurriculumVitaeDto;
import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateService{
	
	DataResult<List<Candidate>> getAll();
    DataResult<Candidate> getByNationalIdentity(String nationalIdentity);
	DataResult<Candidate> get(int id);
	DataResult<Candidate> getById(int id);
	Result add(Candidate candidate);
	Result delete(Candidate canidate);
	DataResult<CurriculumVitaeDto> getCandidateCvById(int candidateId);


}
