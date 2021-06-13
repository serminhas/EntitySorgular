package javacamp.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Schools")
@AllArgsConstructor
@NoArgsConstructor
public class School extends Base{
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
//	@NotNull
//	@Column(name="JobSeekerId")
//	private int jobSeekerId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="JobSeekerId")
	private JobSeeker jobSeeker;
	
	@NotNull
	@Column(name="SchoolName")
	private String schoolName;
	
	@NotNull
	@Column(name="ProgrammeName")
	private String programmeName;
	
	@NotNull
	@Column(name="StartYear") 
	private LocalDate startYear;
	
	@NotNull
	@Column(name="EndYear") 
	private LocalDate endYear;
	
}
