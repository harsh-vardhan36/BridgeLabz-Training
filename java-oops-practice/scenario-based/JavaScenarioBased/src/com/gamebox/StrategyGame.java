package com.gamebox;

class StrategyGame extends Game {

    public StrategyGame(String title, double price, double rating) {
        super(title, "Strategy", price, rating);
    }

    public void download() {
        System.out.println(title + " Strategy game downloading...");
    }

    public void playDemo() {
        System.out.println("Playing brain-teasing strategy demo of " + title);
    }
}
