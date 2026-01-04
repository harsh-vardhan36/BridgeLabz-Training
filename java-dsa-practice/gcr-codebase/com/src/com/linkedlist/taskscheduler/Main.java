package com.linkedlist.taskscheduler;

public class Main {
    public static void main(String[] args) {

        TaskCircularLinkedList scheduler = new TaskCircularLinkedList();

        scheduler.addAtBeginning(new Task(1, "Code", 1, "10-Oct"));
        scheduler.addAtEnd(new Task(2, "Debug", 2, "11-Oct"));
        scheduler.addAtPosition(new Task(3, "Deploy", 1, "12-Oct"), 2);

        System.out.println("All Tasks:");
        scheduler.displayAll();

        System.out.println("\nCurrent Task Rotation:");
        scheduler.viewCurrentAndMoveNext();
        scheduler.viewCurrentAndMoveNext();
        scheduler.viewCurrentAndMoveNext();

        System.out.println("\nSearch Priority 1:");
        scheduler.searchByPriority(1);

        scheduler.removeByTaskId(2);

        System.out.println("\nAfter Removing Task ID 2:");
        scheduler.displayAll();
    }
}
