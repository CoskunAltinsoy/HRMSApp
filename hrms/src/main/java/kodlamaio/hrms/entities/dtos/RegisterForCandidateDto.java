package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import kodlamaio.hrms.entities.abstracts.Dto;
import lombok.Data;


@Data
public class RegisterForCandidateDto implements Dto{
	
	private String firstName;
    private String lastName;
    private String nationalIdentity;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String passwordConfirm;
}
