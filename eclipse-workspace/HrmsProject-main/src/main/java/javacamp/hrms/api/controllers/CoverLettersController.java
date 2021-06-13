package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CoverLetterService;
import javacamp.hrms.business.abstracts.LanguageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CoverLetter;
import javacamp.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}

	 @GetMapping("/getAll")
	public DataResult<List<CoverLetter>>getAllByJobSeekerId(@RequestParam int jobSeekerId) {
		return this.coverLetterService.getAllByJobSeekerId(jobSeekerId);
	}

	 @PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}

	 @PostMapping("/update")
	 public Result update(@RequestBody CoverLetter coverLetter) {
			return this.coverLetterService.update(coverLetter);
		}

	 @PostMapping("/delete")
	 public Result delete(@RequestBody CoverLetter coverLetter) {
			return this.coverLetterService.delete(coverLetter);
		}
}
