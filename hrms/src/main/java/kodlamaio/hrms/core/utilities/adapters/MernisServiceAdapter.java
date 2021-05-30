package kodlamaio.hrms.core.utilities.adapters;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

//import java.time.LocalDate;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;



@Service
public class MernisServiceAdapter implements MernisCheckService{

	@Override
	public Result checkIfRealPerson(Candidate candidate) {
		
		if(checkNationalIdentity(candidate.getNationalIdentity()).isSuccess() 
				&& checkFirstName(candidate.getFirstName()).isSuccess()
				&& checkLastName(candidate.getLastName()).isSuccess()
				&& checkDateOfBirth(candidate.getDateOfBirth()).isSuccess()) {
			
			return new SuccessResult();
							
	     	 }
		return new ErrorResult();
	}
	
	private Result checkNationalIdentity(String nationalId){

        if(nationalId == null){
            return new ErrorResult("Tc No Boş bırakılmamalıdır. ");
        }
        else if (nationalId.length() != 11){
            return new ErrorResult("Tc No 11 karakterli olmalıdır.");
        }
        else
        return new SuccessResult("Tc No Doğrulandı.");
        
	}
	
	 private Result checkFirstName(String firstName){
		 if(firstName == null){
	         return new ErrorResult("Ad alanı boş bırakılmamalıdır.  ");
	       }
	     else if (firstName.length() <2){
	         return new ErrorResult("Ad uzunluğu 2 karakterden kısa olmamalıdır.");
	       }
	     else {
	         return new SuccessResult("Ad alanı doğrulandı.");
	       }
		 }
	 
	 private Result checkLastName(String lastName) {
		 
		 if(lastName == null){
	         return new ErrorResult("Soyad alanı boş bırakılmamalıdır.  ");
	       }
		 else if (lastName.length() <2){
	         return new ErrorResult("Soyad uzunluğu 2 karakterden kısa olmamalıdır.");
	       }
	      else {
	         return new SuccessResult("Soyad alanı doğrulandı.");
	        }	 
		 }
	 
     private Result checkDateOfBirth(LocalDate  dateOfBirth) {
		 
    	 if(dateOfBirth == null){
	         return new ErrorResult("Doğum tarihi alanı boş bırakılmamalıdır.  ");
	       }	         
		 else if (dateOfBirth.isAfter(LocalDate.now())){
	         return new ErrorResult("Date of Birth must be before today");
	       }		    
	     else {
	         return new SuccessResult("Doğum tarihi alanı doğrulandı.");
	        }
		 
	 }
	
		
}
