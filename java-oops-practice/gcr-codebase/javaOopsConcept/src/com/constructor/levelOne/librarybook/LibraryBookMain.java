package com.constructor.levelOne.librarybook;

public class LibraryBookMain {
	public static void main(String[] args) {
		// create object of class LibraryBook
		 LibraryBook book1 = new LibraryBook("Clean Code", "Robert C. Martin", 450);
	        book1.displayDetails();
	        book1.checkAvailability();  
	}
}
