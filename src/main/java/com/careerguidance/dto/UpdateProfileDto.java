package com.careerguidance.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author saumyarani.s
 *
 */
@Getter
@Setter
public class UpdateProfileDto {
	@NotNull
	private int userId;
	@NotNull
	private String firstName;
	private String lastName;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String mobileNo;
	@NotNull
	private String qualification;
	@NotNull
	private String status;
}
