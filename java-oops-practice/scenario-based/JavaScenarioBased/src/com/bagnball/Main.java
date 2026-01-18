package com.bagnball;

public class Main {
    public static void main(String[] args) {

        Bag bag1 = new Bag("B1", "Red", 2);
        Bag bag2 = new Bag("B2", "Blue", 3);

        Ball ball1 = new Ball("BALL1", "Yellow", "Small");
        Ball ball2 = new Ball("BALL2", "Green", "Medium");
        Ball ball3 = new Ball("BALL3", "Blue", "Large");

        bag1.addBall(ball1);
        bag1.addBall(ball2);
        bag1.addBall(ball3); 

        bag1.displayBalls();

        bag1.removeBall("BALL1");
        bag1.displayBalls();

        System.out.println("\n Bag Summary:");
        System.out.println("Bag " + bag1.getId() + " has " + bag1.getBallCount() + " balls");
        System.out.println("Bag " + bag2.getId() + " has " + bag2.getBallCount() + " balls");
    }
}
