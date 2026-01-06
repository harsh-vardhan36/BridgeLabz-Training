package com.edumentor;

public class User {
	 protected String name;
	 protected String userId;
	 private String email;
	 
	public User(String name, String userId, String email) {
		this.name = name;
		this.userId = userId;
		this.email = email;
	}
	public String getName() {return name;}
	public String getId() {return userId;}
	public String getMail() {return email;}
	public void setMail(String email) {
	this.email = email;
	}

}


  