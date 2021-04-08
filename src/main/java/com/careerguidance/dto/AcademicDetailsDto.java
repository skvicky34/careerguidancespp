package com.careerguidance.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademicDetailsDto {

	private Integer userId; 
	@NotNull
	private String subjectName;
	@NotNull
	private Double totalMarks;
	@NotNull
	private String demo;
	@NotNull
	private String board;
	@NotNull
	private String career;
}