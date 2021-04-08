package com.careerguidance.exception;

/*
 * This exception class is used for the existing user email & password validation.
 */
public class ExtistingUserException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExtistingUserException(String message) {
		
		super(message);
	}

}
