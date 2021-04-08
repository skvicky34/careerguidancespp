package com.careerguidance.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkDto {
	
	private Integer userId; 
	@NotNull
	private String map;
}
