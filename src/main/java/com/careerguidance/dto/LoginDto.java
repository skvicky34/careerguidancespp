package com.careerguidance.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * This class contains user login details.
 * @author Amarkant Gupta
 *
 */
@Getter 
@Setter
public class LoginDto {
	@NotNull
	private String email;
	@NotNull
	private String password;


}
