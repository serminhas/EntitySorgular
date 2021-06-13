package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.JobSeekerVerificationService;
import javacamp.hrms.entities.concretes.JobSeeker;

public class JobSeekerVerificationManager implements JobSeekerVerificationService {

	@Override
	public boolean CheckIfRealPerson(JobSeeker jobSeeker) {
		return true;
	}

}


