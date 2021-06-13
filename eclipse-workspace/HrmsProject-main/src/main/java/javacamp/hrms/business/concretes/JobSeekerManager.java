package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobSeekerService;
import javacamp.hrms.core.utilities.adapters.FakeMernisServiceAdapter;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.EmailValidator;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobSeekerDao;
import javacamp.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	JobSeekerDao jobSeekerDao;
	FakeMernisServiceAdapter fakeMernisServiceAdapter;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, FakeMernisServiceAdapter fakeMernisServiceAdapter) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.fakeMernisServiceAdapter=fakeMernisServiceAdapter;
	}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi");
	}
	@Override
	public Result add(JobSeeker jobSeeker) {
		try {
	        if (!EmailValidator.emailFormatController(jobSeeker.getEmail())) {
	            return new ErrorResult(Messages.WrongEmailFormat);
	        }else if(!fakeMernisServiceAdapter.CheckIfRealPerson(jobSeeker)){
	            return new ErrorResult(Messages.WrongIdInfo);
	        }
	        else {
	            this.jobSeekerDao.save(jobSeeker);
	            return new SuccessResult(Messages.JobSeekerAdded);
	        }
	    }catch (Exception e){
	        if (e.getMessage()
	                .equals("could not execute statement; SQL [n/a]; constraint [uc_users_email]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
	            return new ErrorResult(Messages.AlreadyExistedEmail);
	        } else {
	            return new ErrorResult("TCKN sistemde kayıtlıdır.");
	        }
	    }
	}
	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult(Messages.JobSeekerUpdated);
	}
	@Override
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.delete(jobSeeker);
        return new SuccessResult(Messages.JobSeekerDeleted);
	}
	@Override
	public DataResult<JobSeeker> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByJobSeekerId(jobSeekerId));
	}
}
