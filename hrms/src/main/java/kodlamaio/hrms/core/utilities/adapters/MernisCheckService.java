package kodlamaio.hrms.core.utilities.adapters;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisCheckService {
	
	Result checkIfRealPerson(Candidate candidate);

}
