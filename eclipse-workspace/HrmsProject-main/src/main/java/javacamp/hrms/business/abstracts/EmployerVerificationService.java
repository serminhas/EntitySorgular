package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.EmployerVerification;
import javacamp.hrms.entities.concretes.JobSeeker;

public interface EmployerVerificationService {
	boolean CheckIfRealCompany(Employer employer);
	
}
