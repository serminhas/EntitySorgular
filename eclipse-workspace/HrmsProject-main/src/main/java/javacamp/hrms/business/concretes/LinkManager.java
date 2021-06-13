package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.LinkService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.LinkDao;
import javacamp.hrms.entities.concretes.Language;
import javacamp.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService{
	
	private LinkDao linkDao;
	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public DataResult<List<Link>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
        return new SuccessResult(Messages.LinkAdded);
	}

	@Override
	public Result update(Link link) {
		this.linkDao.save(link);
        return new SuccessResult(Messages.LinkUpdated);
	}

	@Override
	public Result delete(Link link) {
		this.linkDao.delete(link);
        return new SuccessResult(Messages.LinkDeleted);
	}

}
