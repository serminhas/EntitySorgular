package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.JobSeekerService;
import javacamp.hrms.business.abstracts.PhotoService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Photo;
import javacamp.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/photos")
public class PhotosController {
	
	private PhotoService photoService;
	private JobSeekerService jobSeekerService;
	
	
	@Autowired
	public PhotosController(PhotoService photoService, JobSeekerService jobSeekerService) {
		super();
		this.photoService = photoService;
		this.jobSeekerService = jobSeekerService;
	}

	 @PostMapping("/add")
	 public Result add(@RequestParam(value = "JobSeekerId") int jobSeekerId, @RequestParam(value = "PhotoFile") MultipartFile photoFile){
			JobSeeker jobSeeker = this.jobSeekerService.getByJobSeekerId(jobSeekerId).getData();
			Photo photo = new Photo();
			photo.setJobSeeker(jobSeeker);
			return this.photoService.add(photo, photoFile);
	 }

	 @PostMapping("/update")
		public Result update(@RequestBody Photo photo) {
			return this.photoService.update(photo);
		}

	 @PostMapping("/delete")
	 public Result delete(@RequestBody Photo photo) {
			return this.photoService.update(photo);
		}
}
