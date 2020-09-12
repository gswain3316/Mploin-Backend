package com.example.MPloin.Exceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {
	
	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
