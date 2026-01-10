package com.runtimeanalysis;

import java.util.*;

public class SortingComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 100000};

        for (int n : sizes) {
            System.out.println("\nDataset Size: " + n);

            int[] original = new int[n];
            Random rand = new Random();

            for (int i = 0; i < n; i++) {
                original[i] = rand.nextInt(n);
            }

            // Bubble Sort 
            if (n <= 10000) {
                int[] bubbleArr = original.clone();
                long start = System.nanoTime();
                bubbleSort(bubbleArr);
                long end = System.nanoTime();
                System.out.println("Bubble Sort Time: " + (end - start) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible");
            }

            // Merge Sort
            int[] mergeArr = original.clone();
            long start = System.nanoTime();
            Arrays.sort(mergeArr); 
            long end = System.nanoTime();
            System.out.println("Merge Sort Time: " + (end - start) / 1_000_000.0 + " ms");

            // Quick Sort 
            int[] quickArr = original.clone();
            start = System.nanoTime();
            Arrays.sort(quickArr);
            end = System.nanoTime();
            System.out.println("Quick Sort Time: " + (end - start) / 1_000_000.0 + " ms");
        }
    }
}
