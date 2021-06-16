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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="curriculum_vitaes")

public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name ="cv_note")
	private String cvNote;
	
	@Column(name ="created_date")
	private LocalDate createdDate;

	
	@Column(name ="linkedin")
	private String linkedin;
	
	@Column(name ="github")
	private String github;
	
	@JsonIgnore
	@JoinColumn(name = "candidate_id")
	@ManyToOne()
	private Candidate candidate;
	
  


}
