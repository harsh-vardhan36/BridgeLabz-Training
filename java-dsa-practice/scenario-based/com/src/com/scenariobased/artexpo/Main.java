package com.scenariobased.artexpo;

public class Main {
    public static void main(String[] args) {

        int[] registrationTimes = { 120, 90, 150, 110, 130 };

        ArtistSorter expo = new ArtistSorter();

        System.out.println("Before sorting registrations:");
        expo.display(registrationTimes);

        expo.insertionSort(registrationTimes);

        System.out.println("After sorting registrations:");
        expo.display(registrationTimes);
    }
}
