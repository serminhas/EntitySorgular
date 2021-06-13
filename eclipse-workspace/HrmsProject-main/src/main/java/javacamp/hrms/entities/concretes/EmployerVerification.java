package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="EmployerVerifications")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerVerification extends Base {
	
	@Id
	@Column(name="EmployerId") 
	private int employerId;
	
	@Column(name="EmailVerification") 
	private boolean emailVerification;
	
	@Column(name="PersonnelVerification")
	private boolean personnelVerification;

	
}
