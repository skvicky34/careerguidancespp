package com.careerguidance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * This class contains recommended courses details.
 * 
 * @author Amarkant Gupta
 *
 */
@Entity
@Table(name = "recommended_courses")
@Getter
@Setter
public class RecommendedCourse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6337285369651485557L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private Double minMarks;
	private Double maxMarks;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rec_courses_type_id")
	private RecommendedCourseType recommendedCourseType;

	/**
	 * default constructor
	 */
	public RecommendedCourse() {

	}

}
