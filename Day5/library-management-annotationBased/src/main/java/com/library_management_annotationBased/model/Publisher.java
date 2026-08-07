package com.library_management_annotationBased.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

	private String name;

	public Publisher(@Value("${publisher.name}") String name) {
		this.name = name;
		System.out.println("Publisher Constructor Executed");
	}

	public void display() {
		System.out.println("Publisher: " + name);
	}
}
