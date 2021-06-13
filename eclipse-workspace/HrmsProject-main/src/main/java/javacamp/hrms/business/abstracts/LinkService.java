package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Link;

public interface LinkService {
	DataResult<List<Link>> getAllByJobSeekerId(int jobSeekerId);
	Result add(Link link);
	Result update(Link link);
	Result delete(Link link);
}
