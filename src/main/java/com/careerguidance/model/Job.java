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
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * This class contains job details.
 * 
 * @author Amarkant Gupta
 *
 */
@Entity
@Table(name = "jobs")
@Getter
@Setter
public class Job implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 3187369584604870369L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private String type;
	private Double minMarks;
	private String minQualification;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "job")
	private UserCareerPath userCareerPath;

}
