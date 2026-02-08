package com.multithreading.restaurantorder;

public class Chef extends Thread {

    private String dish;
    private int totalTime; // in milliseconds

    public Chef(String chefName, String dish, int totalTime) {
        super(chefName);
        this.dish = dish;
        this.totalTime = totalTime;
    }

    @Override
    public void run() {

        System.out.println(getName() + " started preparing " + dish);

        int stepTime = totalTime / 4; // 25% steps

        try {
            for (int i = 1; i <= 4; i++) {
                Thread.sleep(stepTime);
                System.out.println(getName() + " preparing " + dish + ": " + (i * 25) + "% complete");
            }

            System.out.println(getName() + " finished cooking " + dish);

        } catch (InterruptedException e) {
            System.out.println(getName() + " got interrupted while cooking " + dish);
        }
    }
}
