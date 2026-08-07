package com.library_management_javaBased.model;

// Plain POJO - dependencies (Author, Publisher) are passed in by JavaConfig, not @Autowired.
public class Book {

	private String title;
	private double price;

	private Author author;
	private Publisher publisher;

	public Book(String title, double price, Author author, Publisher publisher) {
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
