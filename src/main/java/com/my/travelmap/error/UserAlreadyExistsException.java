package com.my.travelmap.error;

public class UserAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = -3460164782561694886L;

	public UserAlreadyExistsException(String username) {
		super(username + " is already existing...!");
	}
}
