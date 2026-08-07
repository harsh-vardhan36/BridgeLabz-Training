package com.library_management_annotationBased.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Author {

	private String name;

	// @Value pulls the value straight from application.properties
	public Author(@Value("${author.name}") String name) {
		this.name = name;
		System.out.println("Author Constructor Executed");
	}

	public void display() {
		System.out.println("Author: " + name);
	}
}
