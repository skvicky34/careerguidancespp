package com.careerguidance.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * This class contains recommended courses type details.
 * 
 * @author Amarkant Gupta
 *
 */

@Entity
@Table(name = "recommended_courses_type")
@Getter
@Setter
public class RecommendedCourseType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2126962404463346991L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private String recommendedExamName;
	private Integer minMarks;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qualification_id")
	Qualification qualification;

	@OneToMany(mappedBy = "recommendedCourseType", fetch = FetchType.LAZY)
	private Set<RecommendedCourse> recommendedCourses;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "recommendedCourseType")
	private UserCareerPath userCareerPath;
	
	

	/**
	 * default constructor
	 */
	public RecommendedCourseType() {

	}

}
