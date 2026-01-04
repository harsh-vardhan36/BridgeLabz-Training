package com.linkedlist.texteditor;

public class UndoRedoManager {
    private DNode head;
    private DNode tail;
    private DNode current;
    private int size;
    private final int MAX_SIZE = 10;

    public void addState(String text) {
        DNode newNode = new DNode(new TextState(text));

        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = calculateSize();
        }

        if (head == null) {
            head = tail = current = newNode;
            size = 1;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        current = newNode;
        size++;

        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text available");
            return;
        }
        System.out.println("Current Text: " + current.data.content);
    }

    private int calculateSize() {
        int count = 0;
        DNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
