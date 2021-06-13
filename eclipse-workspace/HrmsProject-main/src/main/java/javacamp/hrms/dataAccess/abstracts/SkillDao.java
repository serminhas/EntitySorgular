package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill,Integer>{
	Skill getById(int id);
	List<Skill> getAllByJobSeekerId(int jobSeekerId);
	List<Skill> getAllByTechnologyName(String technologyName);
	List<Skill> getAllByProgrammingLanguage(String programmingLanguage);
}
