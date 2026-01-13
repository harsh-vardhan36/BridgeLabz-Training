package com.gamebox;

abstract class Game implements IDownloadable {

    protected String title;
    protected String genre;
    protected double price;
    protected double rating;

    public Game(String title, String genre, double price, double rating) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

   
    public double applyDiscount(double percent) {
        return price - (price * percent / 100);
    }

    public abstract void playDemo();
}
