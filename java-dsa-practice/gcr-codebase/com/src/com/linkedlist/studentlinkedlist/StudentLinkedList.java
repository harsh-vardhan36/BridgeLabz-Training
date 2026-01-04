package com.linkedlist;

public class StudentLinkedList {
    private Node head;

    public void addAtBeginning(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtPosition(Student student, int position) {
        if (position == 1) {
            addAtBeginning(student);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        Node newNode = new Node(student);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteByRollNo(int rollNo) {
        if (head == null) return;

        if (head.data.rollNo == rollNo) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data.rollNo != rollNo) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void searchByRollNo(int rollNo) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.rollNo == rollNo) {
                displayStudent(temp.data);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    public void updateGrade(int rollNo, char newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.rollNo == rollNo) {
                temp.data.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayAll() {
        Node temp = head;
        while (temp != null) {
            displayStudent(temp.data);
            temp = temp.next;
        }
    }

    private void displayStudent(Student s) {
        System.out.println(
            s.rollNo + " | " + s.name + " | " + s.age + " | " + s.grade
        );
    }
}
