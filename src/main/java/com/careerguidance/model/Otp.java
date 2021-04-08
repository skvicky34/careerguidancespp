package com.careerguidance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Otp implements Serializable {
	
	/**
	 * Unique serial Version UID
	 */
	private static final long serialVersionUID = 5430955878781580881L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String otp;
	
	public Otp() {
		
	}
	
	public Otp(Integer id, String email, String otp) {
		super();
		this.id = id;
		this.email = email;
		this.otp = otp;
	}
}
