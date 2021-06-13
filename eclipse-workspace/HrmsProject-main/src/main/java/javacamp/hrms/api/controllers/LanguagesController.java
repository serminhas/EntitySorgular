package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.LanguageService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.LanguageDao;
import javacamp.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}

	 @GetMapping("/getAll")
	public DataResult<List<Language>>getAllByJobSeekerId(@RequestParam int jobSeekerId) {
		return this.languageService.getAllByJobSeekerId(jobSeekerId);
	}

	 @PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}

	 @PostMapping("/update")
	 public Result update(@RequestBody Language language) {
			return this.languageService.add(language);
		}

	 @PostMapping("/delete")
	 public Result delete(@RequestBody Language language) {
			return this.languageService.add(language);
		}

	 @GetMapping("/getAllByLevel")
	public DataResult<List<Language>> getAllByLevel(@RequestParam int level) {
		 return this.languageService.getAllByLevel(level);
	}
	
}
