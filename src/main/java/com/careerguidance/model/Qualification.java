package com.careerguidance.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * This class contains user qualification data.
 * 
 * @author Amarkant Gupta
 *
 */
@Entity
@Getter
@Setter
public class Qualification implements Serializable {
	private static final long serialVersionUID = -3392341281881397728L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private String appearingExamName;

	@OneToMany(mappedBy = "qualification", fetch = FetchType.LAZY)
	private Set<RecommendedCourseType> recommendedCourseTypes;

	/**
	 * default constructor
	 */
	public Qualification() {
	}

}
