package javacamp.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javacamp.hrms.business.abstracts.JobSeekerService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekersController {
		
		@Autowired
		private JobSeekerService jobSeekerService;

		public JobSeekersController(JobSeekerService jobSeekerService) {
			super();
			this.jobSeekerService = jobSeekerService;
		}
		
		@GetMapping("/getAll")
		public DataResult<List<JobSeeker>> getAll(){
			return this.jobSeekerService.getAll();
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody JobSeeker jobSeeker) {
			return this.jobSeekerService.add(jobSeeker);
		}
}
