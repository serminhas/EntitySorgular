package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Language;
import javacamp.hrms.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getAllByJobSeekerId(int jobSeekerId);
	Result add(Skill skill);
	Result update(Skill skill);
	Result delete(Skill skill);
}
