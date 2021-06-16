package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages/")
public class LanguagesController {
	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("add")
	Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}
	
	@PostMapping("delete")
	Result delete(Language language) {
		return this.languageService.delete(language);
	}
	
	@GetMapping("getall")
	DataResult<List<Language>> getAll(){
		return this.languageService.getAll();
		}
	
	@GetMapping("getbyid")
	DataResult<Language> getById(int id){
		return this.languageService.getById(id);
	}

}
