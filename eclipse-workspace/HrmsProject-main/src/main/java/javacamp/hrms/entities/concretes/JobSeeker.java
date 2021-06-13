package javacamp.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "JobSeekerId")
@Table(name="JobSeekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {
	
	@NotNull
	@Column(name="Firstname") 
	private String firstName;
	
	@NotNull
	@Column(name="Lastname") 
	private String lastName;
	
	@NotNull
	@Column(name="NationalId") 
	private String nationalId;
	
	@NotNull
	@Column(name="Birthyear") 
	private LocalDate birthYear;
	
	//@NotNull
	//@Column(name="PositionId") 
	//private int positionId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="PositionId")
	private JobPosition jobPosition;
	
	@JsonIgnore
	@OneToMany(mappedBy ="jobSeeker")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<Experience> Experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<Link> links;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List<Skill> skills;
	
	@JsonIgnore
	@OneToOne(mappedBy="jobSeeker",optional=false, fetch=FetchType.LAZY)
	private Photo photo;
}
