package com.careerguidance.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Saumyarani S
 *
 */
@Getter 
@Setter
public class ConfirmPasswordDto {
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String confpassword;
	
}
