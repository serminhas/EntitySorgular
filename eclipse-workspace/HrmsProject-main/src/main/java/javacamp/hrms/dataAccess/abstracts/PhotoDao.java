package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo,Integer>{
	Photo getById(int id);
	Photo getByJobSeekerId(int jobSeekerId);

}
