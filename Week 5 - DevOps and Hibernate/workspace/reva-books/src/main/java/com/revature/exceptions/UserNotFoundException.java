package com.revature.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1689381930415180837L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
