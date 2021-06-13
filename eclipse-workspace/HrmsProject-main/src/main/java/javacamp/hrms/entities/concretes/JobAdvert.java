package javacamp.hrms.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@PrimaryKeyJoinColumn(name="JobAdvertPositionId")
@Table(name="JobAdverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert extends JobPosition {
		
	//@NotNull
	//@Id
	//@Column(name="EmployerId") 
	//private int employerId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="EmployerId")
	private Employer employer;
	
	@NotNull
	@Column(name="City") 
	private String city;
	
	@NotNull
	@Column(name="MinSalary") 
	private int minSalary;
	
	@NotNull
	@Column(name="MaxSalary") 
	private int maxSalary;
	
	@NotNull
	@Column(name="OpenPositionNumber") 
	private int openPositionNumber;
	
	@NotNull
	@Column(name="ApplicationDeadline") 
	private LocalDate applicationDeadline;
	
	@NotNull
	@Column(name="PostingDate") 
	private LocalDate postingDate;
	
	@NotNull
	@Column(name="IsPositionActive") 
	private boolean isPositionActive;
	
	@NotNull
	@Column(name="IsPositionPassive") 
	private boolean isPositionPassive;
	
}
