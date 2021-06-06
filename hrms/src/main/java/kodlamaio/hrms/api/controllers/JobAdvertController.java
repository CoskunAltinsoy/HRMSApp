package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts/")
public class JobAdvertController {
	
	private JobAdvertService jobadvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobadvertService) {
		super();
		this.jobadvertService = jobadvertService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobadvertService.getAll();
		}
	
	@PostMapping("add")
	public void add(@RequestBody JobAdvert jobAdvert){
		this.jobadvertService.add(jobAdvert);
		}
	
	@GetMapping("findAllByStatusTrue")
	public DataResult<List<JobAdvert>> findAllByStatusTrue(){
		return this.jobadvertService.findAllByStatusTrue();
		}
	
	@GetMapping("findAllByStatusTrueOrderByDeadlineAsc")
	public DataResult<List<JobAdvert>> findAllByStatusTrueOrderByDeadlineAsc(){
		return this.jobadvertService.findAllByStatusTrueOrderByDeadlineAsc();
		}
	
	@GetMapping("findAllByStatusTrueOrderByPublishedDateDesc")
	public DataResult<List<JobAdvert>> findAllByStatusTrueOrderByPublishedDateDesc(){
		return this.jobadvertService.findAllByStatusTrueOrderByPublishedDateDesc();
		}
	
	
	
	

}
