package com.linkedlist;

public class Main {
    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(new Student(1, "Aman", 20, 'A'));
        list.addAtEnd(new Student(2, "Rohit", 21, 'B'));
        list.addAtPosition(new Student(3, "Harsh", 22, 'A'), 2);

        System.out.println("All Students:");
        list.displayAll();

        System.out.println("\nSearch Roll No 2:");
        list.searchByRollNo(2);

        list.updateGrade(2, 'A');

        System.out.println("\nAfter Grade Update:");
        list.displayAll();

        list.deleteByRollNo(1);

        System.out.println("\nAfter Deletion:");
        list.displayAll();
    }
}
