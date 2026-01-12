package com.scenariobased.trafficmanager;

import java.util.*;

import java.util.*;

public class TrafficManager {

    private Car head = null;
    private Queue<String> waitingQueue = new LinkedList<>();
    private int capacity;

    public TrafficManager(int capacity) {
        this.capacity = capacity;
    }

    public void addCar(String carNo) {
        if (getCount() >= capacity) {
            System.out.println("Roundabout full → sent to waiting queue");
            waitingQueue.add(carNo);
            return;
        }

        Car newCar = new Car(carNo);

        if (head == null) {
            head = newCar;
            newCar.next = head;
        } else {
            Car temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newCar;
            newCar.next = head;
        }

        System.out.println(carNo + " entered roundabout");
    }

    public void removeCar(String carNo) {
        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        Car curr = head, prev = null;

        do {
            if (curr.getNumber().equals(carNo)) {
                if (curr == head) {
                    Car last = head;
                    while (last.next != head)
                        last = last.next;

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }

                System.out.println(carNo + " exited");

                if (!waitingQueue.isEmpty()) {
                    addCar(waitingQueue.poll());
                }
                return;
            }

            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Car not found");
    }

    private int getCount() {
        if (head == null) return 0;

        int count = 0;
        Car temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        Car temp = head;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.getNumber() + " → ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to " + head.getNumber() + ")");
    }
}
