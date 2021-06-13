package javacamp.hrms.entities.dtos;

import java.util.List;

import javacamp.hrms.entities.concretes.CoverLetter;
import javacamp.hrms.entities.concretes.Experience;
import javacamp.hrms.entities.concretes.JobSeeker;
import javacamp.hrms.entities.concretes.Language;
import javacamp.hrms.entities.concretes.Link;
import javacamp.hrms.entities.concretes.Photo;
import javacamp.hrms.entities.concretes.School;
import javacamp.hrms.entities.concretes.Skill;

public class JobSeekerResumeDto {
	public JobSeeker jobSeeker;
	public Photo photo;
	public List<School> schools;
	public List<Skill> skills;
	public List<Link> links;
	public List<Language> languages;
	public List<Experience> experiences;
	public List<CoverLetter> coverLetters;
}
