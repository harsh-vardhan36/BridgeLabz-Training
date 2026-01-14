package com.ecowing;
public class Main {
    public static void main(String[] args) {

        BirdSanctuary sanctuary = new BirdSanctuary();

        sanctuary.addBird(new Eagle("B1", "SkyKing"));
        sanctuary.addBird(new Duck("B2", "Daffy"));
        sanctuary.addBird(new Penguin("B3", "Pingu"));
        sanctuary.addBird(new Kiwi("B4", "KiwiBoy"));

        sanctuary.displayAllBirds();
        sanctuary.report();
    }
}
