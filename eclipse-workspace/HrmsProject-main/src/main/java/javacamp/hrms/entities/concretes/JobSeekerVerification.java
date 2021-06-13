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
@Table(name="JobSeekerVerifications")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerVerification extends Base {
	
	@Column(name="MernisVerification") 
	public boolean mernisVerification;
	
	@Column(name="EmailVerification") 
	public boolean emailVerification;

	@Id
	@Column(name="JobSeekerId") 
	public int jobSeekerId;	
	
	
}
