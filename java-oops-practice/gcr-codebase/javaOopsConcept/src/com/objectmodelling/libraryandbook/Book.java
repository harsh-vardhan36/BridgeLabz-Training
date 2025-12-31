package com.objectmodelling.libraryandbook;
import java.util.ArrayList;
import java.util.List;

// Book class (Independent entity)
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Book: " + title + " | Author: " + author);
    }
}



