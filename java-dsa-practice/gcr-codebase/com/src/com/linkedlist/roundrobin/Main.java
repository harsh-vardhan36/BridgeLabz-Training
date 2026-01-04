package com.linkedlist.roundrobin;

public class Main {
    public static void main(String[] args) {

        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        Process[] processes = {
            new Process(1, 10, 1),
            new Process(2, 5, 2),
            new Process(3, 8, 1)
        };

        for (Process p : processes) {
            scheduler.addProcess(p);
        }

        int timeQuantum = 3;
        scheduler.simulate(timeQuantum);
        scheduler.displayAverages(processes);
    }
}
