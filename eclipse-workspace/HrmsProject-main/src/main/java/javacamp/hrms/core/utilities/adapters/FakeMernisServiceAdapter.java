package javacamp.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobSeekerVerificationService;
import javacamp.hrms.entities.concretes.JobSeeker;

@Service
public class FakeMernisServiceAdapter implements JobSeekerVerificationService  {

	@Override
	public boolean CheckIfRealPerson(JobSeeker jobSeeker) {
		return true;
	}
	
}
