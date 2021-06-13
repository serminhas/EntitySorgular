package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ExperienceService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.ExperienceDao;
import javacamp.hrms.entities.concretes.CoverLetter;
import javacamp.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {
	
	private ExperienceDao experienceDao;
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public DataResult<List<Experience>> getAllByJobSeekerIdOrderByEndYearAtDesc(int jobSeekerId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByJobSeekerIdOrderByEndYearAtDesc(jobSeekerId));
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
        return new SuccessResult(Messages.ExperienceAdded);
	}

	@Override
	public Result update(Experience experience) {
		this.experienceDao.save(experience);
        return new SuccessResult(Messages.ExperienceAdded);
	}

	@Override
	public Result delete(Experience experience) {
		this.experienceDao.delete(experience);
        return new SuccessResult(Messages.ExperienceAdded);
	}

}
