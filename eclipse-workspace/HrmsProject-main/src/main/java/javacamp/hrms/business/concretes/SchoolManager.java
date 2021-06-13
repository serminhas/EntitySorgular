package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javacamp.hrms.business.abstracts.LinkService;
import javacamp.hrms.business.abstracts.SchoolService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.SchoolDao;
import javacamp.hrms.entities.concretes.Link;
import javacamp.hrms.entities.concretes.School;

public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public DataResult<List<School>> getAllByJobSeekerIdOrderByEndYearAtDesc(int jobSeekerId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByJobSeekerIdOrderByEndYearAtDesc(jobSeekerId));
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
        return new SuccessResult(Messages.SchoolAdded);
	}

	@Override
	public Result update(School school) {
		this.schoolDao.save(school);
        return new SuccessResult(Messages.SchoolUpdated);
	}

	@Override
	public Result delete(School school) {
		this.schoolDao.delete(school);
        return new SuccessResult(Messages.SchoolDeleted);
	}

}
