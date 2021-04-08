package com.careerguidance.exception;

/*
 * This exception class throw DataNotFoundException if data not found in DB.
 */
public class DataNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		
		super(message);
	}

}
