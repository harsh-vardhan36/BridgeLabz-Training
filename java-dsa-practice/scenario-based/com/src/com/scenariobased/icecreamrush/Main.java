package com.scenariobased.icecreamrush;

public class Main {
    public static void main(String[] args) {

        int[] flavorSales = { 45, 30, 60, 25, 50, 40, 35, 55 };

        FlavorSorter shop = new FlavorSorter();

        System.out.println("Before sorting flavor popularity:");
        shop.display(flavorSales);

        shop.bubbleSort(flavorSales);

        System.out.println("After sorting flavor popularity:");
        shop.display(flavorSales);
    }
}
