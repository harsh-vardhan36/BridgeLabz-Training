package com.library_management_annotationBased.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library_management_annotationBased.model.Book;

@Component
public class LibraryService {

	private final Book book;

	@Autowired
	public LibraryService(Book book) {
		this.book = book;
	}

	public void displayBook() {
		book.display();
	}
}
