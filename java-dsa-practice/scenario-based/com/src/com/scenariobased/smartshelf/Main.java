package com.scenariobased.smartshelf;

public class Main {
    public static void main(String[] args) {

        Book[] books = {
            new Book("Data Structures"),
            new Book("Algorithms"),
            new Book("Computer Networks"),
            new Book("Operating Systems")
        };

        SmartShelf shelf = new SmartShelf();
        shelf.sortBooks(books);
        shelf.display(books);
    }
}
