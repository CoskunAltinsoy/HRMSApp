package kodlamaio.hrms.core.utilities.Verification;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager implements VerificationService{
	
	@Override
	public void sendVerificationCode(String email) {
		//UUID uuid = UUID.randomUUID();
		//String verificationLink = "https://hrmsactivationemail/" + uuid.toString();
	    System.out.println("Onay kodu şu maile yollandı: " + email);
	   // System.out.println("Please click to link : " + verificationLink);
		
	}

	@Override
	public String codeGenerator() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString(); 
		System.out.println("Onay kodunuz: " + verificationCode);
		return verificationCode;
	}

}
