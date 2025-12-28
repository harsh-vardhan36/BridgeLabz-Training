package com.constructor.levelOne;

public class Book {

	String title, author;
	double price;
	
	Book(String title, String author, double price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	void DisplayBook() {
		System.out.println("Book Title: "+ title);
		System.err.println("Author Name: "+ author );
		System.out.println("Book Price: "+price);
	}
	
}

