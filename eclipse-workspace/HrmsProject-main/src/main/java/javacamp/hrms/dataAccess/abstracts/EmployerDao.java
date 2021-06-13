package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.JobSeeker;

public interface EmployerDao extends JpaRepository<Employer,Integer>{
	Employer getAll();
	List<Employer> getAllByEmployerId(int employerId);
}
