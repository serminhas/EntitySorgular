package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getAllByJobSeekerId(int jobSeekerId);
	DataResult<List<School>> getAllByJobSeekerIdOrderByEndYearAtDesc(int jobSeekerId);
	Result add(School school);
	Result update(School school);
	Result delete(School school);
}
