package com.queue.reverse;

import java.util.*;

public class ReverseQueue {

    public static void reverseQueue(Queue<Integer> q) {
        // Base case
        if (q.isEmpty()) {
            return;
        }

        int front = q.remove();

        reverseQueue(q);

        q.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Before Reverse: " + q);
        reverseQueue(q);
        System.out.println("After Reverse: " + q);
    }
}
