package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Experience;
import javacamp.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School,Integer>{
	School getById(int id);
	List<School> getAllByJobSeekerId(int jobSeekerId);
	List<School> getAllByJobSeekerIdOrderByEndYearAtDesc(int jobSeekerId);
	
}
