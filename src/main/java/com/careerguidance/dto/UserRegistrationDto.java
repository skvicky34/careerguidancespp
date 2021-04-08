package com.careerguidance.dto;


import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Amarkant Gupta
 *
 */

@Getter 
@Setter
public class UserRegistrationDto {

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String confirmPassword;
	@NotNull
	private String mobileNo;
	@NotNull
	private String qualification;
	@NotNull
	private String status;
		
}
