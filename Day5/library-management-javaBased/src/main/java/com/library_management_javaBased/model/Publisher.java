package com.library_management_javaBased.model;

// Plain POJO - no @Component here.
public class Publisher {

	private String name;

	public Publisher(String name) {
		this.name = name;
		System.out.println("Publisher Constructor Executed");
	}

	public void display() {
		System.out.println("Publisher: " + name);
	}
}
