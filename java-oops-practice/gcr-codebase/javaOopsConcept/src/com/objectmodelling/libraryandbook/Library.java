package com.objectmodelling.libraryandbook;

import java.util.ArrayList;
import java.util.List;

//Library class (Aggregates Books)
class Library {
 private String name;
 private List<Book> books;  // Aggregation: Library HAS-A list of Books

 // Constructor
 public Library(String name) {
     this.name = name;
     this.books = new ArrayList<>();
 }

 // Add book to library
 public void addBook(Book book) {
     books.add(book);
 }

 // Display all books in library
 public void showLibraryBooks() {
     System.out.println("Library: " + name);
     for (Book book : books) {
         book.displayBook();
     }
 }
}
