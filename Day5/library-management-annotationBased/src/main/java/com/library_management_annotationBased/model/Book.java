package com.library_management_annotationBased.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

	private String title;
	private double price;

	private Author author;
	private Publisher publisher;

	// @Autowired lets Spring inject the Author and Publisher beans automatically.
	// It is optional on a single constructor (Spring 4.3+) but written here for clarity.
	@Autowired
	public Book(@Value("${book.title}") String title,
	            @Value("${book.price}") double price,
	            Author author,
	            Publisher publisher) {
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}

	public void display() {
		System.out.println("\nBook Details");
		System.out.println("----------------");
		System.out.println("Title : " + title);
		System.out.println("Price : " + price);

		author.display();
		publisher.display();
	}
}
