package com.careerguidance.model;

/**
 * This class contains user career intrest.
 * @author Amarkant Gupta
 *
 */
public class UserIntrest {
	private Integer id;
	private String name;

	/**
	 * default constructor
	 */
	public UserIntrest() {
	}

	/**
	 * parameterized constructor
	 * @param id
	 * @param name
	 */
	public UserIntrest(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
