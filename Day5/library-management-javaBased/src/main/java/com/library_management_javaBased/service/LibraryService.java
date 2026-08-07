package com.library_management_javaBased.service;

import com.library_management_javaBased.model.Book;

// Plain POJO - no @Component, no @Autowired. JavaConfig wires the Book in.
public class LibraryService {

	private final Book book;

	public LibraryService(Book book) {
		this.book = book;
	}

	public void displayBook() {
		book.display();
	}
}
