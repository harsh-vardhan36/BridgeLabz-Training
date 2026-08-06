package com.library_management_xml.model;

public class LibraryService {
private Book book;
public LibraryService() {
	System.out.println("Library Bean Created!");
}
public void setBook(Book book) {
	this.book = book;
}
public void displayBook() {
	book.display();
}

}
