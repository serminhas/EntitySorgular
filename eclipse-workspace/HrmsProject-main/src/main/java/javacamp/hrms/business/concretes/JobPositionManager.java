package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.business.abstracts.JobPositionService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobPositionDao;
import javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), Messages.JobPositionListed); 
	}

	@Override
	public Result add(JobPosition jobPosition) {
		try {
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult(Messages.JobPositionAdded);
        }catch (Exception e) {
            return new ErrorResult(Messages.AlreadyExistedJobPosition);
        }
		
	}

	@Override
	public DataResult<List<JobPosition>> getByPositionName(String positionName) {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByPositionName(positionName), Messages.JobPositionSelected);
	}

	@Override
	public Result update(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.JobPositionUpdated);
	}

	@Override
	public Result delete(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.JobPositionDeleted);
	}

}
