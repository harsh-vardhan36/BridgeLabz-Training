package com.scenariobased.smartlibrary;

public class Main {
    public static void main(String[] args) {

        String[] borrowedBooks = {
            "Algorithms",
            "Data Structures",
            "Java Programming",
            "Artificial Intelligence"
        };

        BookSorter library = new BookSorter();

        System.out.println("Before sorting borrowed books:");
        library.display(borrowedBooks);

        library.insertionSort(borrowedBooks);

        System.out.println("\nAfter sorting borrowed books:");
        library.display(borrowedBooks);
    }
}
