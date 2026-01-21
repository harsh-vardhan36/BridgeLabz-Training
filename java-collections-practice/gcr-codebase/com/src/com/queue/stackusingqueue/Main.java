package com.queue.stackusingqueue;

public class Main {

    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top()); // 3
        System.out.println("Pop: " + stack.pop()); // 3
        System.out.println("Top after pop: " + stack.top()); // 2
    }
}
