package com.java8.lambda.filtering;

public class Alert {
    private String type;
    private String message;
    public Alert(String type, String message) {
    	this.type = type;
    	this.message = message;
    	
    }
    public String getMessage() {
    	return message;
    }
    public String getType() {
    	return type;
    }
  
}
