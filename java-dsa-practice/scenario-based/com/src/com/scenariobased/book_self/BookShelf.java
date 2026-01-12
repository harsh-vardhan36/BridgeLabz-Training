package com.scenariobased.book_self;

import java.util.*;

public class BookShelf {

    // List of Books
    private HashMap<String, LinkedList<Book>> library = new HashMap<>();

    // To prevent duplicates
    private HashSet<Book> bookSet = new HashSet<>();

    // Add Book
    public void addBook(String genre, Book book) {

        if (bookSet.contains(book)) {
            System.out.println("Duplicate book not allowed: " + book);
            return;
        }

        library.putIfAbsent(genre, new LinkedList<>());
        library.get(genre).add(book);
        bookSet.add(book);

        System.out.println(book + " added to " + genre);
    }

    
    
    public void borrowBook(String genre, String title) {
        if (!library.containsKey(genre)) {
            System.out.println("Genre not found");
            return;
        }

        LinkedList<Book> list = library.get(genre);

        for (Book b : list) {
            if (b.getTitle().equals(title)) {
                list.remove(b);
                bookSet.remove(b);
                System.out.println(b + " borrowed");
                return;
            }
        }

        System.out.println("Book not found");
    }

    // Display Library
    public void display() {
        for (String genre : library.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book b : library.get(genre)) {
                System.out.println("  " + b);
            }
        }
    }
}
