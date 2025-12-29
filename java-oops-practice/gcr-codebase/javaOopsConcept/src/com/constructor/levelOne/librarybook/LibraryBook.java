package com.constructor.levelOne.librarybook;

public class LibraryBook {
	String title;
	String author;
     double price;
     boolean availability;
     
     	//parametrized constructors
     	LibraryBook(String title, String author, double price){
			this.title = title;
			this.author = author;
			this.price = price;
			availability = true;
     	}
     	
     	// create method
	void checkAvailability() {
		 if (availability) {
	            availability = false;
	            System.out.println("Book borrowed successfully!");
	        } else {
	            System.out.println("Sorry, the book is already borrowed.");
	        }
	 }
	
	   void displayDetails() {
	        System.out.println("Title: " + title);
	        System.out.println("Author: " + author);
	        System.out.println("Price: ₹" + price);
	        System.out.println("Available: " + availability);
	    }
}
