package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.ExperienceService;
import javacamp.hrms.business.abstracts.SkillService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.entities.concretes.Experience;
import javacamp.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

	private ExperienceService experienceService;

	  public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	  }
	  
	  @GetMapping("/getAll")
		public DataResult<List<Experience>> getAllByJobSeekerId(@RequestParam int jobSeekerId) {
			return this.experienceService.getAllByJobSeekerId(jobSeekerId);
		}
	  
	  
	  @GetMapping("/getAllByJobSeekerIdOrderByEndYearAtDesc")
		public DataResult<List<Experience>> getAllByJobSeekerIdOrderByEndYearAtDesc(@RequestParam int jobSeekerId) {
			return this.experienceService.getAllByJobSeekerIdOrderByEndYearAtDesc(jobSeekerId);
		}

	  @PostMapping("/add")
		public Result add(@RequestBody Experience experience) {
			return this.experienceService.add(experience);
		}

	  @PostMapping("/update")
		public Result update(@RequestBody Experience experience) {
			return this.experienceService.update(experience);
		}

	  @PostMapping("/delete")
		public Result delete(@RequestBody Experience experience) {
			return this.experienceService.delete(experience);
		}
	
}
