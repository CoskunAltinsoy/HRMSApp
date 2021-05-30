package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
    	super();
        this.authService = authService;
    }

    @PostMapping("registerForEmployer")
    public Result registerForEmployer(@RequestBody RegisterForEmployerDto registerForEmployerDto){
        return this.authService.registerForEmployer(registerForEmployerDto);
    }

    @PostMapping("registerForCandidate")
    public Result registerForCandidate(@RequestBody RegisterForCandidateDto registerForCandidateDto){
        return this.authService.registerForCandidate(registerForCandidateDto);
    }
}
