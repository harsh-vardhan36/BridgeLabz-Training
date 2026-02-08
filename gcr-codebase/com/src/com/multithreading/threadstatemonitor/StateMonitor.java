package com.multithreading.threadstatemonitor;

import java.time.LocalTime;
import java.util.HashSet;

public class StateMonitor extends Thread {

    private Thread t1, t2;

    private HashSet<Thread.State> statesT1 = new HashSet<>();
    private HashSet<Thread.State> statesT2 = new HashSet<>();

    public StateMonitor(Thread t1, Thread t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public void run() {

        while (true) {

            Thread.State s1 = t1.getState();
            Thread.State s2 = t2.getState();

            // Save observed states
            statesT1.add(s1);
            statesT2.add(s2);

            // Print monitoring output
            System.out.println("[Monitor] " + t1.getName() + " is in " + s1 +
                    " state at " + LocalTime.now());

            System.out.println("[Monitor] " + t2.getName() + " is in " + s2 +
                    " state at " + LocalTime.now());

            System.out.println("-----------------------------------");

            // Stop monitoring when both finished
            if (s1 == State.TERMINATED && s2 == State.TERMINATED) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted!");
            }
        }

        // Summary
        System.out.println("\n========= SUMMARY =========");
        System.out.println(t1.getName() + " went through " + statesT1.size() + " states: " + statesT1);
        System.out.println(t2.getName() + " went through " + statesT2.size() + " states: " + statesT2);
    }
}
