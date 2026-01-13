package com.gamebox;
public class Main {
    public static void main(String[] args) {

        Game g1 = new ArcadeGame("Speed Racer", 500, 4.5);
        Game g2 = new StrategyGame("War Tactics", 800, 4.8);

        g1.playDemo();   
        g2.playDemo();   

        System.out.println("Discounted price of " + g1.title + " = " + g1.applyDiscount(20));

        User u = new User("Harsh");
        u.buyGame(g1);
        u.buyGame(g2);

        u.showLibrary();
    }
}
