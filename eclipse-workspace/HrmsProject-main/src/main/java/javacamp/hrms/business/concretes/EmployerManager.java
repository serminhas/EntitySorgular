package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.EmailValidator;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	@Override
	
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<Employer>(this.employerDao.getAll(), Messages.EmployerListed );
	}
	
	@Override
	public DataResult<List<Employer>> getAllByEmployerId(int employerId) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getAllByEmployerId(employerId), Messages.EmployerListed );
	}
	
	
	
	@Override
	public Result add(Employer employer) {		
				
		String[] employerWebsite = employer.getWebsite().split("\\.", 2);
        String website = employerWebsite[1];

        String[] employerEmail = employer.getEmail().split("@");
        String employerDomain = employerEmail[1];
        try {
            if (!EmailValidator.emailFormatController(employer.getEmail())) {
                return new ErrorResult(Messages.WrongEmailFormat);
            } else if (!employerDomain.equals(website)) {
                return new ErrorResult(Messages.WrongCompanyDomain);
            } else {
                this.employerDao.save(employer);
                return new SuccessResult(Messages.EmployerAdded);
            }
        } catch (Exception e) {
            if (e.getMessage()
                    .equals("could not execute statement; SQL [n/a]; constraint [uc_users_email]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
                return new ErrorResult(Messages.AlreadyExistedEmail);
            } else {
                return new ErrorResult(Messages.AlreadyExistedCompany);
            }
        }
	}
        @Override
    	public Result update(Employer employer) {
        	this.employerDao.save(employer);
			return new SuccessResult(Messages.EmployerUpdated);
        }
        @Override
    	public Result delete(Employer employer) {
        	this.employerDao.save(employer);
			return new SuccessResult(Messages.EmployerDeleted);
        }
		
    }
		


