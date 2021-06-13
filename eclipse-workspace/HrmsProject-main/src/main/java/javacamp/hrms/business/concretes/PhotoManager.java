package javacamp.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.LinkService;
import javacamp.hrms.business.abstracts.PhotoService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.photoupload.PhotoUploadService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.PhotoDao;
import javacamp.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService{
	
	private PhotoDao photoDao;
	private PhotoUploadService photoUploadService;

	@Autowired
	public PhotoManager(PhotoDao photoDao, PhotoUploadService photoUploadService) {
		super();
		this.photoDao = photoDao;
		this.photoUploadService=photoUploadService;
	}	
	
	@Override
	public Result add(Photo photo, MultipartFile photoFile) {
			Map<String,String> uploadImage = this.photoUploadService.uploadImageFile(photoFile).getData();
			photo.setUrl(uploadImage.get("url"));
			this.photoDao.save(photo);
			return new SuccessResult(Messages.PhotoUploaded);
		
	}

	@Override
	public Result update(Photo photo) {
		this.photoDao.save(photo);
        return new SuccessResult(Messages.PhotoUpdated);
	}

	@Override
	public Result delete(Photo photo) {
		this.photoDao.delete(photo);
        return new SuccessResult(Messages.PhotoDeleted);
	}

}
