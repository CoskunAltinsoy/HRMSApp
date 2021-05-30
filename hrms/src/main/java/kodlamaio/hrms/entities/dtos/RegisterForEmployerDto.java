package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.abstracts.Dto;
import lombok.Data;


@Data
public class RegisterForEmployerDto  implements Dto {
	
	private String website;
    private String phoneNumber;
    private String companyName;
    private String email;
    private String password;
    private String passwordConfirm;
}
