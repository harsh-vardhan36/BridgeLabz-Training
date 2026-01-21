package com.queue.circularbuffer;

public class CircularBuffer {

    private int[] buffer;
    private int size;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;

        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size;
        }
    }

    public void display() {
        System.out.print("Buffer: [ ");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println("]");
    }
}
