package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Photos")
@AllArgsConstructor
@NoArgsConstructor
public class Photo extends Base{
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
//	@NotNull
//	@Column(name="JobSeekerId")
//	private int jobSeekerId;
	
	@OneToOne(optional=false,fetch=FetchType.LAZY) 
	@JoinColumn(name = "JobSeekerId")
	private JobSeeker jobSeeker;
	
	@NotNull
	@Column(name="Url")
	private String url;
}
