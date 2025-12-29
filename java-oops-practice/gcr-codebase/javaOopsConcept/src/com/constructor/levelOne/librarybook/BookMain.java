package com.constructor.levelOne.librarybook;

public class BookMain {
	public static void main(String[] args) {
		  Ebook ebook = new Ebook(
	                "978-0135166307",
	                "Effective Java",
	                "Joshua Bloch",
	                "PDF"
	        );

	        ebook.displayEBookDetails();
  }
}
