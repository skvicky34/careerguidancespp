package com.careerguidance.dto;

import lombok.Getter;
import lombok.Setter;
/**
 * This class is responsible to hold user career option.
 * @author Amarkant Gupta
 *
 */
@Getter
@Setter
public class UserCareerPathDto {
	private String type;
	private String name;
	private String description;
	private String userChoice;

}

