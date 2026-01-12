package com.scenariobased.book_self;

public class Main {
    public static void main(String[] args) {

        BookShelf shelf = new BookShelf();

        shelf.addBook("Fiction", new Book("1984", "George Orwell"));
        shelf.addBook("Fiction", new Book("The Alchemist", "Paulo Coelho"));
        shelf.addBook("Tech", new Book("Clean Code", "Robert Martin"));

        shelf.addBook("Fiction", new Book("1984", "George Orwell")); // duplicate

        shelf.display();

        shelf.borrowBook("Fiction", "1984");

        System.out.println("\nAfter borrowing:");
        shelf.display();
    }
}
