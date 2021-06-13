package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.SkillService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {
  
	private SkillService skillService;

	@Autowired
  public SkillsController(SkillService skillService) {
	super();
	this.skillService = skillService;
  }
  
  @GetMapping("/getAll")
	public DataResult<List<Skill>> getAllByJobSeekerId(@RequestParam int jobSeekerId) {
		return this.skillService.getAllByJobSeekerId(jobSeekerId);
	}

  @PostMapping("/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}

  @PostMapping("/update")
	public Result update(@RequestBody Skill skill) {
		return this.skillService.update(skill);
	}

  @PostMapping("/delete")
	public Result delete(@RequestBody Skill skill) {
		return this.skillService.delete(skill);
	}
  
}
