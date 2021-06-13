package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "EmployerId")
@Table(name="Employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {
	
	@OneToMany(mappedBy="employer")
	private List<JobAdvert> JobAdverts;
	
	@NotNull
	@Column(name="CompanyName")
	private String companyName;
	
	@NotNull
	@Column(name="Website")
	private String website;
	
	@NotNull
	@Column(name="Phone")
	private String phone;
	
	//@NotNull
	//@Column(name="PositionId")
	//private int positionId;

	@NotNull
	@ManyToOne
	@JoinColumn(name="PositionId")
	private JobPosition jobPosition;
	
}
