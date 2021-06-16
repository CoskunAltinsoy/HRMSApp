package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")//, referencedColumnName ="id")
@Table(name="candidates")

public class Candidate extends User {
	
	
	@Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="national_identity")
    private String nationalIdentity;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CurriculumVitae> curriculumVitaes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Education> educations; 
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Image> image;
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Language> languages;
       
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Skill> skill;   
    
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<JobExperiance> jobExperiance;
   
}
