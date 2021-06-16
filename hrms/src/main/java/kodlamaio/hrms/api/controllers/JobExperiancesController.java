package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperianceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperiance;

@RestController
@RequestMapping("/api/JobExperiances/")
public class JobExperiancesController {
	private JobExperianceService jobExperianceService;
	
	@Autowired
	public JobExperiancesController(JobExperianceService jobExperianceService) {
		super();
		this.jobExperianceService = jobExperianceService;
	}
	
	@PostMapping("add")
	Result add(@RequestBody JobExperiance jobExperiance) {
		return this.jobExperianceService.add(jobExperiance);		
	}
	
	@PostMapping("delete")
	Result delete(JobExperiance jobExperiance) {
		return this.jobExperianceService.delete(jobExperiance);
	}
	
	@GetMapping("getall")
	DataResult<List<JobExperiance>> getAll(){
		return this.jobExperianceService.getAll();
	}
	
	@GetMapping("getbyid")
	DataResult<JobExperiance> getById(int id){
		return this.jobExperianceService.getById(id);
	}
	
	@GetMapping("getAllByCandidate_idOrderByEndOfDate")
	DataResult<List<JobExperiance>> getAllByCandidate_idOrderByEndOfDate(int id){
		return this.jobExperianceService.getAllByCandidateIdOrderByEndOfDate(id);
	}

}
