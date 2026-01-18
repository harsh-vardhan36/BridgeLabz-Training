package com.scenariobased.robowarehouse;

public class Main {
    public static void main(String[] args) {

        int[] packageWeights = { 25, 10, 40, 15, 30 };

        ShelfSorter robot = new ShelfSorter();

        System.out.println("Before loading (unsorted):");
        robot.display(packageWeights);

        robot.insertionSort(packageWeights);

        System.out.println("After loading (sorted by weight):");
        robot.display(packageWeights);
    }
}
