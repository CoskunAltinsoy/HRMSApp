package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="verification_codes")
public class VerificationCode {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private int id;
   
	    @Column(name="verification_code")
	    private String verificationCode;

	    @Column(name="is_confirmed")
	    private boolean isConfirmed = true;

	    @Column(name = "confirm_date")
	    private LocalDate confirmDate;
	    
	    public VerificationCode(int id, String verificationCode, boolean isConfirmed){
	    	
	    	this.id = id;
	    	this.verificationCode = verificationCode;
	    	this.isConfirmed = isConfirmed;
	    	
	    }

}
