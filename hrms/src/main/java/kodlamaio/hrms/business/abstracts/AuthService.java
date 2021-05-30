package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;

public interface AuthService {
	
	 Result registerForCandidate(RegisterForCandidateDto registerForCandidateDto);
	 Result registerForEmployer(RegisterForEmployerDto registerForEmployerDto);
}
