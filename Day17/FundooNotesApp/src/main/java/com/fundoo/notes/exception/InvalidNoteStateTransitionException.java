package com.fundoo.notes.exception;

public class InvalidNoteStateTransitionException extends RuntimeException {
	public InvalidNoteStateTransitionException(String message) {
		super(message);
	}
}
