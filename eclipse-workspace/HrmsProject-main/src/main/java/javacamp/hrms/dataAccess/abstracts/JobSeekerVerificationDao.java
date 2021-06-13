package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobSeekerVerification;

public interface JobSeekerVerificationDao extends JpaRepository<JobSeekerVerification,Integer>{
	JobSeekerVerification getByJobSeekerId(int jobSeekerId);

}
