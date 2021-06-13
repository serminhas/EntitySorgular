package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Experience;
import javacamp.hrms.entities.concretes.School;

public interface ExperienceService {
	DataResult<List<Experience>> getAllByJobSeekerId(int jobSeekerId);
	DataResult<List<Experience>> getAllByJobSeekerIdOrderByEndYearAtDesc(int jobSeekerId);
	Result add(Experience experience);
	Result update(Experience experience);
	Result delete(Experience experience);
}
