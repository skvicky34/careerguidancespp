package com.careerguidance.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is used to hold User details.
 * 
 * @author Amarkant Gupta
 *
 */
@Entity
@Getter
@Setter
public class User implements Serializable {

	/**
	 * Unique serial Version UID
	 */
	private static final long serialVersionUID = -1458546747652324485L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobileNo;
	private String qualification;
	private String status;
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "user")
    private UserCareerPath userCareerPath;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "user")
    private AcademicDetails academicDetails;


	/**
	 * default constructor
	 */
	public User() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param mobileNo
	 * @param qualification
	 * @param status
	 * @param aggregate
	 * @param science
	 * @param maths
	 * @param english
	 */
	public User(Integer id, String firstName, String lastName, String email, String password, String mobileNo,
			String qualification, String status) {
		this(firstName, lastName, email, password, mobileNo, qualification, status);
		this.id = id;
//		this.aggregate = aggregate;
//		this.science = science;
//		this.maths = maths;
//		this.english = english;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param mobileNo
	 * @param qualification
	 * @param status
	 */
	public User(String firstName, String lastName, String email, String password, String mobileNo,
			String qualification, String status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.qualification = qualification;
		this.status = status;
	}
	
	

}
