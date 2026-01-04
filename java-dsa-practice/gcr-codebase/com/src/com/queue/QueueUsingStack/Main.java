package com.queue;

public class Main {
    public static void main(String[] args) {

        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(40);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
