package com.linkedlist.moviemanagement;

public class DNode {
    Movie data;
    DNode next;
    DNode prev;

    DNode(Movie data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
