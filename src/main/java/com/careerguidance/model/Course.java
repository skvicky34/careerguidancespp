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
 * This class contains course details.
 * 
 * @author Amarkant Gupta
 *
 */
@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -8215067937421800059L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private String type;
	private Double minMarks;
	private String minQualification;
	
	

}
