package com.artify;

public abstract class Artwork {
    protected String title;
    protected String artist;
    protected double price;
    protected String licenseType;

    protected Artwork(String title, String artist, double price, String licenseType) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.licenseType = licenseType;
    }

    protected void showLicense() {
        System.out.println("License Type: " + licenseType);
    }

    public double getPrice() {
        return price;
    }
}
