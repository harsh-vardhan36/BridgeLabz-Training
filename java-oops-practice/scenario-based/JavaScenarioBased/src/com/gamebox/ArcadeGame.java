package com.gamebox;
class ArcadeGame extends Game {

    public ArcadeGame(String title, double price, double rating) {
        super(title, "Arcade", price, rating);
    }

    public void download() {
        System.out.println(title + " Arcade game downloading...");
    }

    public void playDemo() {
        System.out.println("Playing fast-paced arcade demo of " + title);
    }
}
