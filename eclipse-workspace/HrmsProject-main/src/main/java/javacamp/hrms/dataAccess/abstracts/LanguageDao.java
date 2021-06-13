package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CoverLetter;
import javacamp.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language,Integer>{
	Language getById(int id); 
	List<Language> getAllByLevel(int level);
	List<Language> getAllByJobSeekerId(int jobSeekerId);
}
