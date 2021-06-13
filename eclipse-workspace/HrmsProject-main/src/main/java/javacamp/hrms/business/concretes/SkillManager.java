package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javacamp.hrms.business.abstracts.LinkService;
import javacamp.hrms.business.abstracts.SkillService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.ExperienceDao;
import javacamp.hrms.dataAccess.abstracts.SkillDao;
import javacamp.hrms.entities.concretes.Experience;
import javacamp.hrms.entities.concretes.Skill;

public class SkillManager implements SkillService{

	private SkillDao skillDao;
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}
	
	@Override
	public DataResult<List<Skill>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Skill>>(this.skillDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
        return new SuccessResult(Messages.SkillAdded);
	}

	@Override
	public Result update(Skill skill) {
		this.skillDao.save(skill);
        return new SuccessResult(Messages.SkillUpdated);
	}

	@Override
	public Result delete(Skill skill) {
		this.skillDao.save(skill);
        return new SuccessResult(Messages.SkillDeleted);
	}

}
