package com.linkedlist.moviemanagement;

public class MovieDoublyLinkedlList {
    private DNode head;
    private DNode tail;

    public void addAtBeginning(Movie movie) {
        DNode newNode = new DNode(movie);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addAtEnd(Movie movie) {
        DNode newNode = new DNode(movie);
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void addAtPosition(Movie movie, int position) {
        if (position == 1) {
            addAtBeginning(movie);
            return;
        }
        DNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(movie);
            return;
        }
        DNode newNode = new DNode(movie);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void removeByTitle(String title) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data.title.equals(title)) {
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
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByDirector(String director) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data.director.equals(director)) {
                displayMovie(temp.data);
            }
            temp = temp.next;
        }
    }

    public void searchByRating(double rating) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data.rating == rating) {
                displayMovie(temp.data);
            }
            temp = temp.next;
        }
    }

    public void updateRating(String title, double newRating) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data.title.equals(title)) {
                temp.data.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        DNode temp = head;
        while (temp != null) {
            displayMovie(temp.data);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        DNode temp = tail;
        while (temp != null) {
            displayMovie(temp.data);
            temp = temp.prev;
        }
    }

    private void displayMovie(Movie m) {
        System.out.println(
            m.title + " | " + m.director + " | " + m.year + " | " + m.rating
        );
    }
}
