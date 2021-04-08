package com.careerguidance.service;

import java.net.UnknownHostException;
import java.util.List;

import com.careerguidance.dto.AcademicDetailsDto;
import com.careerguidance.dto.ConfirmPasswordDto;
import com.careerguidance.dto.LoginDto;
import com.careerguidance.dto.SubjectDto;
import com.careerguidance.dto.UpdateProfileDto;
import com.careerguidance.dto.UserRegistrationDto;
import com.careerguidance.model.User;

/**
 * 
 * @author Amarkant Gupta
 *
 */
public interface IUserService {

	User saveUser(UserRegistrationDto registration) throws UnknownHostException;

	User getUser(LoginDto loginDto);

	User getUser(ConfirmPasswordDto confirmPasswordDto);

	boolean saveUser(User user) throws UnknownHostException;
	
	//void updateUserAcadmicDetails(UserAcadmicDetails acadmicDetails);
   
	//Method to update User profile details.
	boolean updateUser(UpdateProfileDto updateProfileDto);

	User getUser(int userId);

	User getUser(AcademicDetailsDto academicDetailsDto);

	Integer updateUserAcadmicDetails(AcademicDetailsDto academicDetailsDto);

	void updateUserAcadmicDetailsSubjects(List<SubjectDto> subjectList, Integer academicDetailsId, Integer id);

}
