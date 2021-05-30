package kodlamaio.hrms.core.utilities.Verification;

public interface VerificationService {
	
	void sendVerificationCode(String email);
	String codeGenerator();

}
