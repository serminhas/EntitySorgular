package javacamp.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	Result update(JobAdvert jobAdvert);
	Result close(int PositionId);
	DataResult<JobAdvert> getByPositionId(int PositionId);
	DataResult<List<JobAdvert>> getActiveJobAdvertList();
	DataResult<List<JobAdvert>> getActiveJobAdvertByPostingDateList();
	DataResult<List<JobAdvert>> getActiveJobAdvertByEmployerList(int id);
}
