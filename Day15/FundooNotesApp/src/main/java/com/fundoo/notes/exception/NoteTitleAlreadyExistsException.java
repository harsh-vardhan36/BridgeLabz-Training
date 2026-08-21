package com.fundoo.notes.exception;

public class NoteTitleAlreadyExistsException extends RuntimeException {
	public NoteTitleAlreadyExistsException(String message) {
		super(message);
	}
}
