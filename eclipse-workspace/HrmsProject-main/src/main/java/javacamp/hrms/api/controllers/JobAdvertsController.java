package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javacamp.hrms.business.abstracts.JobAdvertService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {

		private JobAdvertService jobAdvertService;
		
		@Autowired
		public JobAdvertsController(JobAdvertService jobAdvertService) {
			super();
			this.jobAdvertService = jobAdvertService;
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody JobAdvert jobAdvert) {
			return this.jobAdvertService.add(jobAdvert);
		}
		
		@GetMapping("/getActiveJobAdvertList")
		public DataResult<List<JobAdvert>> getActiveJobAdvertList() {
			return this.jobAdvertService.getActiveJobAdvertList();
		}

		@GetMapping("/getActiveJobAdvertByPostingDateList")
		public DataResult<List<JobAdvert>> getActiveJobAdvertByPostingDateList() {
			return this.jobAdvertService.getActiveJobAdvertByPostingDateList();
		}

		@GetMapping("/getActiveJobAdvertByEmployerList")
		public DataResult<List<JobAdvert>> getActiveJobAdvertByEmployerList(int id) {
			return this.jobAdvertService.getActiveJobAdvertByEmployerList(id);
		}
		
		@PostMapping("/close")
		public Result close(@RequestBody int positionId) {
			return this.jobAdvertService.close(positionId);
		}
		
		
}
