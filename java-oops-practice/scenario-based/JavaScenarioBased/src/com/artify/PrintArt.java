package com.artify;

public class PrintArt extends Artwork implements IPurchasable {

    public PrintArt(String title, String artist, double price, String licenseType) {
        super(title, artist, price, licenseType);
    }

    @Override
    public void purchase(User user) {
        user.deductBalance(price);
        System.out.println(user.getName() + " purchased printed art: " + title);
    }

    @Override
    public void license(User user) {
        System.out.println("Print usage license issued to " + user.getName());
        showLicense();
    }
}
