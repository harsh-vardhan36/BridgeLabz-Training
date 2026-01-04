package com.linkedlist.moviemanagement;

public class Main {
    public static void main(String[] args) {

        MovieDoublyLinkedlList list = new MovieDoublyLinkedlList();

        list.addAtBeginning(new Movie("Inception", "Nolan", 2010, 8.8));
        list.addAtEnd(new Movie("Interstellar", "Nolan", 2014, 8.6));
        list.addAtPosition(new Movie("Avatar", "Cameron", 2009, 7.8), 2);

        System.out.println("Forward Display:");
        list.displayForward();

        System.out.println("\nReverse Display:");
        list.displayReverse();

        System.out.println("\nSearch by Director Nolan:");
        list.searchByDirector("Nolan");

        list.updateRating("Avatar", 8.0);

        System.out.println("\nAfter Rating Update:");
        list.displayForward();

        list.removeByTitle("Inception");

        System.out.println("\nAfter Deletion:");
        list.displayForward();
    }
}

