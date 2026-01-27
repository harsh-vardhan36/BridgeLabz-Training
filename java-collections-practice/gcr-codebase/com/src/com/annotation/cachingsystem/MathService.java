package com.annotation.cachingsystem;

class MathService {

    @CacheResult
    public int slowSquare(int number) {

        System.out.println("Computing square for " + number);

        try {
            Thread.sleep(2000); // simulate expensive computation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return number * number;
    }
}
