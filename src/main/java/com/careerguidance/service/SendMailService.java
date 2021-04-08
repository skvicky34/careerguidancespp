package com.careerguidance.service;

import com.careerguidance.model.Otp;

public interface SendMailService {
	
	public void sendOtp(String otp,String email);

	String generateOtp() throws ClassNotFoundException;

	public Otp saveOtp(String email, String otp); 
	
	public Otp updateOtp(Otp otp); 

}
