package com.scenariobased.bookself;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        Book b1 = new Book("Harry Potter", "J.K Rowling");
        Book b2 = new Book("The Hobbit", "Tolkien");
        Book b3 = new Book("Harry Potter", "J.K Rowling");

        lib.addBook("Fantasy", b1);
        lib.addBook("Fantasy", b2);
        lib.addBook("Fantasy", b3);   // duplicate blocked

        lib.showLibrary();

        lib.borrowBook("Fantasy", b1);
        lib.showLibrary();
    }
}

