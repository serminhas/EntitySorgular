package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.EmployerVerification;
import javacamp.hrms.entities.concretes.JobSeeker;
import javacamp.hrms.entities.concretes.JobSeekerVerification;

public interface JobSeekerVerificationService {
	boolean CheckIfRealPerson(JobSeeker jobSeeker);
	
	
}
