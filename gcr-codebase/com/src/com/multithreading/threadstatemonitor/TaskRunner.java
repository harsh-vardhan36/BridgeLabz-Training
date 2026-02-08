package com.multithreading.threadstatemonitor;

public class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {

        try {
            // Step 1: Sleep (TIMED_WAITING)
            Thread.sleep(2000);

            // Step 2: Computation (RUNNABLE)
            long sum = 0;
            for (int i = 1; i <= 1_000_000; i++) {
                sum += i;
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted!");
        }
    }
}
