package com.multithreading.threadstatemonitor;

public class ThreadStateMain {

    public static void main(String[] args) {

        // Task threads (Initially NEW)
        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");

        // Monitor thread
        StateMonitor monitor = new StateMonitor(task1, task2);

        // Start monitoring before tasks start
        monitor.start();

        // Start tasks
        task1.start();
        task2.start();
    }
}
