package com.careerguidance.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Amarkant Gupta
 *
 */
@Getter 
@Setter
public class UserAcadmicDetails {
	private Integer userId; 
	@NotNull
	private Double aggregate;
	@NotNull
	private Integer science;
	@NotNull
	private Integer maths;
	@NotNull
	private Integer english;
	@NotNull
	private String qualification;

}
