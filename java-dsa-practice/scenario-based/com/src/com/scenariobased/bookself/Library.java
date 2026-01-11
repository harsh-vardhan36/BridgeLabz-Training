package com.scenariobased.bookself;

import java.util.*;

class Library {
    HashMap<String, LinkedList<Book>> catalog = new HashMap<>();
    HashSet<Book> allBooks = new HashSet<>();

    // Add book
    void addBook(String genre, Book book) {
        if (allBooks.contains(book)) {
            System.out.println("Duplicate book not allowed: " + book);
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        allBooks.add(book);

        System.out.println("Added: " + book + " to " + genre);
    }

    // Borrow book
    void borrowBook(String genre, Book book) {
        if (!catalog.containsKey(genre)) return;

        LinkedList<Book> list = catalog.get(genre);

        if (list.remove(book)) {
            allBooks.remove(book);
            System.out.println("Borrowed: " + book);
        } else {
            System.out.println("Book not found");
        }
    }

    // Display library
    void showLibrary() {
        for (String genre : catalog.keySet()) {
            System.out.println("\n" + genre + ":");
            for (Book b : catalog.get(genre)) {
                System.out.println("  " + b);
            }
        }
    }
}
