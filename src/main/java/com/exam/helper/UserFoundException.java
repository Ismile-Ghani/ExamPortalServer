package com.exam.helper;

public class UserFoundException extends Exception {

	public UserFoundException() {
		super("User Found In our Database. Try with different one");
		
	}

	public UserFoundException(String message) {
		super(message);
		
	}
	
	

}
