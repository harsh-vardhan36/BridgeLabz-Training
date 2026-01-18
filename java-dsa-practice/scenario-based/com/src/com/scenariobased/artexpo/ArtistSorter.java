package com.scenariobased.artexpo;

public class ArtistSorter {

    public void insertionSort(int[] regTime) {
        for (int i = 1; i < regTime.length; i++) {
            int current = regTime[i];
            int j = i - 1;

            while (j >= 0 && regTime[j] > current) {
                regTime[j + 1] = regTime[j];
                j--;
            }

            regTime[j + 1] = current;
        }
    }

    public void display(int[] regTime) {
        for (int t : regTime) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
