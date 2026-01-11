package com.artify;

public class Main {
    public static void main(String[] args) {

        User user = new User("Harsh", 5000);

        IPurchasable art1 = new DigitalArt("Cyber City", "Alex", 2000, "Personal Use");
        IPurchasable art2 = new PrintArt("Vintage Frame", "Emma", 1500, "Commercial Print");

        art1.purchase(user);
        art1.license(user);

        System.out.println("Remaining balance: " + user.getWalletBalance());

        art2.purchase(user);
        art2.license(user);

        System.out.println("Remaining balance: " + user.getWalletBalance());
    }
}

