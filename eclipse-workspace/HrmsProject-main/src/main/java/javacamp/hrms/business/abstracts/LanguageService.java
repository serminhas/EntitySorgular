package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Language;
import javacamp.hrms.entities.concretes.School;

public interface LanguageService {
	DataResult<List<Language>> getAllByJobSeekerId(int jobSeekerId);
	DataResult<List<Language>> getAllByLevel(int level);
	Result add(Language language);
	Result update(Language language);
	Result delete(Language language);
}
