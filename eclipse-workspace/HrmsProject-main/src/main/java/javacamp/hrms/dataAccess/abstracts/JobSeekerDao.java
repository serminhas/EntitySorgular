package javacamp.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.concretes.JobSeeker;
import javacamp.hrms.entities.concretes.User;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
	JobSeeker getById(int id);
	JobSeeker getByJobSeekerId(int jobSeekerId);
	
}
