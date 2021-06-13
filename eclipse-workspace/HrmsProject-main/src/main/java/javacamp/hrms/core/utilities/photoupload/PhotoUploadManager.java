package javacamp.hrms.core.utilities.photoupload;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;

@Service
public class PhotoUploadManager implements PhotoUploadService{

	private Cloudinary cloudinary;

	@Autowired
	public PhotoUploadManager(Cloudinary cloudinary) {
         
		this.cloudinary=cloudinary;
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile photoFile) {
        
		try {
			@SuppressWarnings("unchecked")
			Map<String,String> resultMap =(Map<String, String>) cloudinary.uploader().upload(photoFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>(Messages.PhotoError);
	}
	
}
