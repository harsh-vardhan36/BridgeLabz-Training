package com.linkedlist.texteditor;

public class DNode {
    TextState data;
    DNode next;
    DNode prev;

    DNode(TextState data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
