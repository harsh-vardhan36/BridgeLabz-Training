package com.runtimeanalysis;

import java.util.*;

public class SearchComparison {

    // Linear Search
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target)
                return true;
        }
        return false;
    }

    // Binary Search
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 1_000_000};

        for (int n : sizes) {
            System.out.println("\nDataset size: " + n);

            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = i;
            }

            int target = n - 1; 

            // Linear Search Timing
            long start = System.nanoTime();
            linearSearch(data, target);
            long end = System.nanoTime();
            System.out.println("Linear Search Time: " + (end - start) / 1_000_000.0 + " ms");

            // Sorting for Binary Search
            start = System.nanoTime();
            Arrays.sort(data);
            long sortTime = System.nanoTime() - start;

            // Binary Search Timing
            start = System.nanoTime();
            binarySearch(data, target);
            end = System.nanoTime();

            System.out.println("Sorting Time: " + sortTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + (end - start) / 1_000_000.0 + " ms");
        }
    }
}
