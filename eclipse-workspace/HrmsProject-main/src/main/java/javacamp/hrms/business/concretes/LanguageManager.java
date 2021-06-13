package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.LanguageService;
import javacamp.hrms.business.constants.Messages;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.LanguageDao;
import javacamp.hrms.entities.concretes.Experience;
import javacamp.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>>getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getAllByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
        return new SuccessResult(Messages.LanguageAdded);
	}

	@Override
	public Result update(Language language) {
		this.languageDao.save(language);
        return new SuccessResult(Messages.LanguageUpdated);
	}

	@Override
	public Result delete(Language language) {
		this.languageDao.delete(language);
        return new SuccessResult(Messages.LanguageDeleted);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataResult<List<Language>> getAllByLevel(int level) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getAllByLevel(level));
	}



	
}
