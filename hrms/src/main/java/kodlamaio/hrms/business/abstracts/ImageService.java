package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	
	Result add(Image image, MultipartFile imageFile);
	Result delete(int id);
	DataResult<Image> getByCandidateId(int candidateId);	
	DataResult<List<Image>> getAll(); 
}
