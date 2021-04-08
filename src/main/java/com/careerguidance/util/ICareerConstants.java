package com.careerguidance.util;


/*
 * This interface contains all constants for Career Guidance.
 */
public interface ICareerConstants {
	
	String SALT = "aassssbbnn!!!!";
	
	String LOGIN_ERR_MSG="Invalid email or password.";
	String DB_ERR_MSG="Oops something went wrong into database";
	String SESSION_ID="JSESSIONID";
	String CAREER_DATA_SV_MSG="Career selection data saved successfully.";
	String USER_REG_SUCCESS_MSG="User registered successfully.";
	String PASSWORD_DIFFERENT_ERROR_MSG="Password mismatch. Try again.";
	String PASSWORD_CHANGE_SUCCESS_MSG="Password changed successfully.";
	String PASSWORD_CHANGE_ERROR_MSG="Password change failed. Please re-enter the password correctly.";
	String PASSWORD_CHANGE_OLD_ERROR_MSG="Please do not use the old password.";
	String USER_ALREADY_EXIST_MSG="User already exists.";
	String ACADMIC_SUCCESS_MSG = "Acadmic details updated successfully.";
	String USER_NOT_EXIST_MSG="User not exists with mail id";
	String INVALID_OTP="Invalid OTP. Please try again";
	String PROFILE_UPDATE_SUCCESS_MSG="Profile details updated successfully.";
	String PROFILE_UPDATE_FAIL_MSG="Profile could not be updated. Try again.";
	String ACADEMIC_DETAILS_UPDATE_FAIL_MSG="Academic Details could not be updated. Try again.";
	String EMAIL_TO_CC = "";
    String EMAIL_SUBJECT = "CAREER GUIDANCE Password Reset";
    String EMAIL_TEXT = " is OTP for CAREER GUIDANCE, Please do not share OTP with "+"anyone.";

}
