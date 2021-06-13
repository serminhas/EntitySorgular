package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.UserService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), Messages.UserListed) ;
	}


	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult(Messages.UserAdded);
	}


	@Override
	public Result update(User user) {
		this.userDao.save(user);
		return new SuccessResult(Messages.UserUpdated);
	}


	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult(Messages.UserDeleted);
	}

}
