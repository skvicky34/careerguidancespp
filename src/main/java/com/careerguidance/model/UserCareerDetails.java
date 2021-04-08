package com.careerguidance.model;

/**
 * 
 * @author Sandeep Kumar
 *
 */
public class UserCareerDetails {
	private Integer id;
	private String course;
	private String college;
	private String job;
	private String description;

	public UserCareerDetails(String course, String college, String job, String description) {
		this.course = course;
		this.college = college;
		this.job = job;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}