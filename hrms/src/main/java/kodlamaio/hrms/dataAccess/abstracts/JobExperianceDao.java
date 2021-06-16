package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobExperiance;

public interface JobExperianceDao extends JpaRepository<JobExperiance, Integer>{
	
	JobExperiance findById(int id);
	List<JobExperiance> findAllByCandidate_idOrderByEndOfDate(int id);
	List<JobExperiance> findByCandidate_id(int candidateId);

}
