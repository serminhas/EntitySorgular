package javacamp.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Base {
	
	@JsonIgnore
	@Column(name= "CreatedDate", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate createdAt = LocalDate.now();
	
	@JsonIgnore
	@Column(name= "IsActive", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@JsonIgnore
	@Column(name= "IsDeleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;
	
}
