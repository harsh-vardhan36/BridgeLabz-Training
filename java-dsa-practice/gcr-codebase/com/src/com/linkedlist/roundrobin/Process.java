package com.linkedlist.roundrobin;

public class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnAroundTime;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}
