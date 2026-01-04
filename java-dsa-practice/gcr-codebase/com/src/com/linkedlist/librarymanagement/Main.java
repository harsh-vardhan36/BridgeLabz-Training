package com.linkedlist.librarymanagement;

public class Main {
    public static void main(String[] args) {

        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        library.addAtBeginning(new Book(1, "Java Basics", "James", "Programming", true));
        library.addAtEnd(new Book(2, "DSA Made Easy", "Robert", "Education", true));
        library.addAtPosition(new Book(3, "Clean Code", "Robert", "Software", false), 2);

        System.out.println("Library (Forward):");
        library.displayForward();

        System.out.println("\nLibrary (Reverse):");
        library.displayReverse();

        System.out.println("\nSearch by Author Robert:");
        library.searchByAuthor("Robert");

        library.updateAvailability(3, true);

        System.out.println("\nAfter Availability Update:");
        library.displayForward();

        library.removeByBookId(1);

        System.out.println("\nAfter Removing Book ID 1:");
        library.displayForward();

        System.out.println("\nTotal Books:");
        System.out.println(library.getTotalBooks());
    }
}
