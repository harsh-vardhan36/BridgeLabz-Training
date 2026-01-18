package com.scenariobased.robowarehouse;

public class ShelfSorter {

    public void insertionSort(int[] weights) {
        int n = weights.length;

        for (int i = 1; i < n; i++) {
            int current = weights[i];
            int j = i - 1;

            while (j >= 0 && weights[j] > current) {
                weights[j + 1] = weights[j];
                j--;
            }

            weights[j + 1] = current;
        }
    }

    public void display(int[] weights) {
        for (int w : weights) {
            System.out.print(w + " ");
        }
        System.out.println();
    }
}
