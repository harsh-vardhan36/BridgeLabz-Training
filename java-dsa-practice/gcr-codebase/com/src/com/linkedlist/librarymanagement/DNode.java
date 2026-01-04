package com.linkedlist.librarymanagement;

public class DNode {
    Book data;
    DNode next;
    DNode prev;

    DNode(Book data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
