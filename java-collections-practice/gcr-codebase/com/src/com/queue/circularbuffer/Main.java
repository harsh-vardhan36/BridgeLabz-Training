package com.queue.circularbuffer;

public class Main {

    public static void main(String[] args) {

        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();   // [1 2 3]

        cb.insert(4);
        cb.display();   // [2 3 4]
    }
}
