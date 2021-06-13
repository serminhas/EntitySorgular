package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer>{
	CoverLetter getById(int id);
	
	List<CoverLetter> getByJobSeekerId(int jobSeekerId);
	//List<CoverLetter> getByWritingAreaContains(String writingArea); Araştır!!
	
}
