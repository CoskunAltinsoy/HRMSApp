package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations/")
public class EducationsController {
	
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Education education) {
		return this.add(education);
	}
	
	@PostMapping("delete")
	public Result  delete(@RequestBody Education education) {
		return this.delete(education);
	}
	
	@GetMapping("getall")
	DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	
	@GetMapping("getbyid")
	DataResult<Education> getById(int id){
		return this.educationService.getById(id);	
	}
	
	@GetMapping("getAllByCandidateidOrderByDateOfGraduationDesc")
	DataResult<List<Education>> getAllByCandidateidOrderByDateOfGraduationDesc(int id){
		return this.educationService.getAllByCandidateIdOrderByDateOfGraduationDesc(id);
	}

}
