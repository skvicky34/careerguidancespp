package com.careerguidance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 * This class contains user academic subject and marks details.
 * @author Amarkant Gupta
 *
 */
@Entity
@Table(name = "user_academic_subjects")
@Getter
@Setter
public class UserAcademicSubject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4702365746294581274L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subjectMarks;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_details_id")
	AcademicDetails academicDetails;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
	private Subject subject;
	

}
