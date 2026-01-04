package com.linkedlist.librarymanagement;

public class LibraryDoublyLinkedList {
    private DNode head;
    private DNode tail;
    private int count;

    public void addAtBeginning(Book book) {
        DNode newNode = new DNode(book);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
    }

    public void addAtEnd(Book book) {
        DNode newNode = new DNode(book);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }

    public void addAtPosition(Book book, int position) {
        if (position == 1) {
            addAtBeginning(book);
            return;
        }
        DNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(book);
            return;
        }
        DNode newNode = new DNode(book);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        count++;
    }

    public void removeByBookId(int bookId) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data.bookId == bookId) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                count--;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByTitle(String title) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data.title.equals(title)) {
                displayBook(temp.data);
            }
            temp = temp.next;
        }
    }

    public void searchByAuthor(String author) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data.author.equals(author)) {
                displayBook(temp.data);
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int bookId, boolean status) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data.bookId == bookId) {
                temp.data.available = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        DNode temp = head;
        while (temp != null) {
            displayBook(temp.data);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        DNode temp = tail;
        while (temp != null) {
            displayBook(temp.data);
            temp = temp.prev;
        }
    }

    public int getTotalBooks() {
        return count;
    }

    private void displayBook(Book b) {
        System.out.println(
            b.bookId + " | " + b.title + " | " + b.author + " | " +
            b.genre + " | " + (b.available ? "Available" : "Issued")
        );
    }
}
