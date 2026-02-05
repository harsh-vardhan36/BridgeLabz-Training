package com.librarymanagement.singelton;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {

	// SINGLE INSTANCE
	private static LibraryCatalog instance;

	private List<Book> books = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();

	// PRIVATE CONSTRUCTOR
	private LibraryCatalog() {
	}

	// GLOBAL ACCESS POINT
	public static synchronized LibraryCatalog getInstance() {
		if (instance == null) {
			instance = new LibraryCatalog();
		}
		return instance;
	}

	// OBSERVER METHODS
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	// ADD BOOK & NOTIFY
	public void addBook(
		    Book book
		) {
		    books.add(book);
		}


	private void notifyObservers(String bookName) {
		for (Observer observer : observers) {
			observer.update("New book available: " + bookName);
		}
	}

	public void addBook(com.librarymanagement.builder.Book book) {
		
	}
}