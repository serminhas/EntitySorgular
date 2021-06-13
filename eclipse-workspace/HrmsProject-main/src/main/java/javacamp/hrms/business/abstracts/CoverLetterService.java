package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	DataResult<List<CoverLetter>> getAllByJobSeekerId(int jobSeekerId);
	Result add(CoverLetter coverLetter);
	Result update(CoverLetter coverLetter);
	Result delete(CoverLetter coverLetter);
}
