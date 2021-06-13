package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.EmployerVerification;
import javacamp.hrms.entities.concretes.Experience;

public interface EmployerVerificationDao extends JpaRepository<EmployerVerification,Integer>{
	EmployerVerification getByEmployerId(int employerId);
}
