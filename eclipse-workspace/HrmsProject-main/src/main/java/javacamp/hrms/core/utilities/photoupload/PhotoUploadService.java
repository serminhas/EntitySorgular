package javacamp.hrms.core.utilities.photoupload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.DataResult;

public interface PhotoUploadService {
	DataResult<Map> uploadImageFile(MultipartFile photoFile);
}
