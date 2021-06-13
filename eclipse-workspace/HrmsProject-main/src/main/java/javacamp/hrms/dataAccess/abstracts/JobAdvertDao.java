package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.JobAdvert;
import javacamp.hrms.entities.concretes.JobPosition;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	@Query("From JobAdvert where isPositionActive = true")
	List<JobAdvert> getActiveJobAdvertList();
	
	@Query("From JobAdvert where isPositionActive = true Order By PostingDate Desc")
	List<JobAdvert> getActiveJobAdvertByPostingDateList();
	
	//Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.
	@Query("From JobAdvert where isPositionActive = true and EmployerId=:id")
	List<JobAdvert> getActiveJobAdvertByEmployerList(int id);
	
	
}
