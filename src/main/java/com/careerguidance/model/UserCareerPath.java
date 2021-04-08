package com.careerguidance.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
/**
 * This class is responsible to hold user career option.
 * @author Amarkant Gupta
 *
 */
@Entity
@Getter
@Setter
public class UserCareerPath implements Serializable {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 817348369685999085L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String name;
	private String description;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private RecommendedCourseType recommendedCourseType;

	public UserCareerPath() {
		
	}
	

}

