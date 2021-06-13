package javacamp.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Photo;

public interface PhotoService {
	Result add(Photo photo, MultipartFile photoFile);
	Result update(Photo photo);
	Result delete(Photo photo);
}
