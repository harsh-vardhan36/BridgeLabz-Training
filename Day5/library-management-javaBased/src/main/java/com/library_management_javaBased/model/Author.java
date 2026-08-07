package com.library_management_javaBased.model;

// Plain POJO - no @Component here.
// In Java-based config, Spring doesn't scan for beans; we hand it the objects ourselves.
public class Author {

	private String name;

	public Author(String name) {
		this.name = name;
		System.out.println("Author Constructor Executed");
	}

	public void display() {
		System.out.println("Author: " + name);
	}
}
