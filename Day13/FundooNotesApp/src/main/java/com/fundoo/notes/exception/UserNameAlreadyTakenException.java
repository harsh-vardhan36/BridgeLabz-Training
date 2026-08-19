package com.fundoo.notes.exception;

public class UserNameAlreadyTakenException extends RuntimeException {
	public UserNameAlreadyTakenException(String message) {
		super(message);
	}
}
