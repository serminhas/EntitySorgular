package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.EmployerVerificationService;
import javacamp.hrms.entities.concretes.Employer;

public class EmployerVerificationManager implements EmployerVerificationService {

	@Override
	public boolean CheckIfRealCompany(Employer employer) {
		return false;
	}

}
