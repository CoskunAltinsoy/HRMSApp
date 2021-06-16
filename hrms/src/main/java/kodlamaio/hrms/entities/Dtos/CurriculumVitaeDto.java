package kodlamaio.hrms.entities.Dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobExperiance;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {
	
	private Candidate candidate;
	private List<CurriculumVitae> curriculumVitae;
	private List<Education> educations;
	private Image image;
	private List<JobExperiance> jobExperiances;
	private List<Language> languages;
	private List<Skill> skills;
	

}
