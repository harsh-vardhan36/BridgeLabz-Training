package com.artify;

public class DigitalArt extends Artwork implements IPurchasable {

    public DigitalArt(String title, String artist, double price, String licenseType) {
        super(title, artist, price, licenseType);
    }

    @Override
    public void purchase(User user) {
        user.deductBalance(price);
        System.out.println(user.getName() + " purchased digital art: " + title);
    }

    @Override
    public void license(User user) {
        System.out.println("Digital license granted to " + user.getName());
        showLicense();
    }
}
