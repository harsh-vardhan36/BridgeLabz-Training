package com.bagnball;

import java.util.ArrayList;
import java.util.List;

class Bag implements Storable {
    private String id;
    private String color;
    private int capacity;
    private List<Ball> balls;

    public Bag(String id, String color, int capacity) {
        this.id = id;
        this.color = color;
        this.capacity = capacity;
        this.balls = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getBallCount() {
        return balls.size();
    }

    // Add ball
    public void addBall(Ball ball) {
        if (balls.size() >= capacity) {
            System.out.println(" Bag " + id + " is FULL!");
            return;
        }
        balls.add(ball);
        System.out.println(" Ball added to Bag " + id);
    }

    public void removeBall(String ballId) {
        for (Ball b : balls) {
            if (b.getId().equals(ballId)) {
                balls.remove(b);
                System.out.println(" Ball removed from Bag " + id);
                return;
            }
        }
        System.out.println(" Ball not found!");
    }

    // Display balls
    public void displayBalls() {
        System.out.println("\nBag " + id + " contains:");
        if (balls.isEmpty()) {
            System.out.println("No balls inside.");
            return;
        }
        for (Ball b : balls) {
            System.out.println(b);
        }
    }
}
