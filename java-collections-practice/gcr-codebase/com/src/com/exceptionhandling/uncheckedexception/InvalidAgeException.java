package com.exceptionhandling.uncheckedexception;

public class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}
