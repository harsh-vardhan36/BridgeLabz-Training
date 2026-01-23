package com.scenariobased.foodfest;

public class FoodFestMain {

    public static void main(String[] args) {

        Stall[] stalls = {
            new Stall("Burger Hub", 250),
            new Stall("Pizza Point", 180),
            new Stall("Taco Town", 300),
            new Stall("Pasta Place", 180),
            new Stall("Dessert Den", 400)
        };

        MergeSortUtil.mergeSort(stalls, 0, stalls.length - 1);

        System.out.println("FoodFest Stall Performance Report:");
        for (Stall s : stalls) {
            System.out.println(s.stallName + " -> " + s.footfall + " visitors");
        }
    }
}
