package com.objectmodelling.libraryandbook;

public class LibraryMain{
 public static void main(String[] args) {
     // Create independent Book objects
     Book b1 = new Book("The Alchemist", "Paulo Coelho");
     Book b2 = new Book("Clean Code", "Robert C. Martin");
     Book b3 = new Book("Effective Java", "Joshua Bloch");

     // Create two libraries
     Library lib1 = new Library("City Library");
     Library lib2 = new Library("University Library");

     // Add books to libraries
     lib1.addBook(b1);
     lib1.addBook(b2);

     lib2.addBook(b2); // Same book can exist in multiple libraries
     lib2.addBook(b3);

     // Display books in each library
     lib1.showLibraryBooks();
     lib2.showLibraryBooks();
 }
}