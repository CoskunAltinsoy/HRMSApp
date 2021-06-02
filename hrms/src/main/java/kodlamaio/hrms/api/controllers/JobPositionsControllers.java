package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsControllers {
	
	private JobPositionService jobPositionService;
    
	@Autowired
	public JobPositionsControllers(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
	


	 @PostMapping("add")
	 public void add(@RequestBody JobPosition jobPosition){
	    this.jobPositionService.add(jobPosition);
	 }

}
