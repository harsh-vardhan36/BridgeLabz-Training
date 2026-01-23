package com.scenariobased.fitnesstracker;

public class FitnessTrackerMain {

    public static void main(String[] args) {

        User[] users = {
            new User("Aman", 8500),
            new User("Riya", 12000),
            new User("Kunal", 6000),
            new User("Neha", 9800),
            new User("Arjun", 15000)
        };

        BubbleSortUtil.bubbleSort(users);

        System.out.println("Daily Step Leaderboard:");
        for (User u : users) {
            System.out.println(u.name + " -> " + u.steps + " steps");
        }
    }
}
