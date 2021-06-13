package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CoverLetterService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CoverLetterDao;
import javacamp.hrms.entities.concretes.CoverLetter;
import javacamp.hrms.entities.concretes.JobAdvert;
import javacamp.hrms.entities.concretes.JobSeeker;

@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public DataResult<List<CoverLetter>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.getByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
        return new SuccessResult(Messages.CoverLetterAdded);
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
        return new SuccessResult(Messages.CoverLetterUpdated);
	}

	@Override
	public Result delete(CoverLetter coverLetter) {
		this.coverLetterDao.delete(coverLetter);
        return new SuccessResult(Messages.CoverLetterDeleted);
	}

}
