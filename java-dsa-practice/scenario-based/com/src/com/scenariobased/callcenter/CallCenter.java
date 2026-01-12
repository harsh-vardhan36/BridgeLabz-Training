package com.scenariobased.callcenter;

import java.util.*;

public class CallCenter {

    private Queue<Customer> normalQueue = new LinkedList<>();

    private PriorityQueue<Customer> vipQueue = new PriorityQueue<>(
        (a, b) -> a.getId() - b.getId()
    );

    private HashMap<Integer, Integer> callCount = new HashMap<>();

    public void receiveCall(Customer c) {
        if (c.isVIP())
            vipQueue.add(c);
        else
            normalQueue.add(c);

        callCount.put(c.getId(), callCount.getOrDefault(c.getId(), 0) + 1);
    }

    public void attendCall() {
        Customer c;

        if (!vipQueue.isEmpty())
            c = vipQueue.poll();
        else
            c = normalQueue.poll();

        if (c != null)
            System.out.println("Attending: " + c.getName());
        else
            System.out.println("No calls waiting");
    }

    public void showCallFrequency() {
        System.out.println("Call History: " + callCount);
    }
}
