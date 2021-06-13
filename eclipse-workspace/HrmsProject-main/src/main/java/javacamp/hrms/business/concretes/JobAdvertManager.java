package javacamp.hrms.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobAdvertService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobAdvertDao;
import javacamp.hrms.entities.concretes.JobAdvert;
@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		if (!CheckNullFields(jobAdvert)) {
			return new ErrorResult(Messages.NoJobAdvertAdded);
		}
		this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult(Messages.JobAdvertAdded);
	}
	
	private boolean CheckNullFields(JobAdvert jobAdvert) {
		//getPositionName, getPositionDescription eksik!!
		if (jobAdvert.getCity()!=null && jobAdvert.getOpenPositionNumber()!=0 && jobAdvert.getApplicationDeadline()!=null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public DataResult<List<JobAdvert>> getActiveJobAdvertList() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getActiveJobAdvertList());
	}

	@Override
	public DataResult<List<JobAdvert>> getActiveJobAdvertByPostingDateList() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getActiveJobAdvertByPostingDateList());
	}

	@Override
	public DataResult<List<JobAdvert>> getActiveJobAdvertByEmployerList(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getActiveJobAdvertByEmployerList(id));
	}

	@Override
	public DataResult<JobAdvert> getByPositionId(int PositionId) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getOne(PositionId));
	}

	@Override
	public Result close(int PositionId) {
		JobAdvert jobAdvert=getByPositionId(PositionId).getData();
		jobAdvert.setPositionActive(false);
		return new SuccessResult(Messages.JobAdvertClosed);
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult(Messages.JobAdvertUpdated);
	}

	
}
