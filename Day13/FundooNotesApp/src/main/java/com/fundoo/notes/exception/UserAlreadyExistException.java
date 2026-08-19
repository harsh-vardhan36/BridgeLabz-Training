package com.fundoo.notes.exception;

public class UserAlreadyExistException  extends RuntimeException {
	
	public UserAlreadyExistException(String message) {
		super(message);
	}
}
