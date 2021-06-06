package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="job_adverts")
@JsonIgnoreProperties("hibernateLazyInitializer\",\"handler\",\"products")
public class JobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "min_salary")
	private String minSalary;
	
	@Column(name = "max_salary")
	private String maxSalary;
	
	@Column(name = "number_of_available_positions")
	private String numberOfAvailablePositions;
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@Column(name = "published_date")
	private LocalDate publishedDate;
	
	@Column(name = "status")
	private boolean status;
	
	//@Column(name = "employer_id")
    //private int employerId;
  
	//@Column(name = "job_position_id")
    //private int jobPositionId;
    
	//@Column(name = "city_id")
    //private int cityId;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

}
