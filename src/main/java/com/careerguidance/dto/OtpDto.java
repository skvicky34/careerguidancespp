package com.careerguidance.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class OtpDto {
	
	@NotNull
	private String email;
	
	@NotNull
	private String otp;

}
