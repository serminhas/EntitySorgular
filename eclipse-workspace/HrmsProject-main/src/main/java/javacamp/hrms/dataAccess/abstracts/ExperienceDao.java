package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Experience;
import javacamp.hrms.entities.concretes.School;

public interface ExperienceDao extends JpaRepository<Experience,Integer>{
	Experience getById(int id);
	List<Experience> getAllByJobSeekerId(int jobSeekerId);
	List<Experience> getAllByJobSeekerIdOrderByEndYearAtDesc(int jobSeekerId);

}
