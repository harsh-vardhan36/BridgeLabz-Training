package com.linearandbinarysearch.challengeproblem;

import java.util.Arrays;

public class SearchCombo {

    // Find first missing positive integer (Linear Search logic)
    public static int firstMissingPositive(int[] arr) {

        int n = arr.length;
        boolean[] present = new boolean[n + 1];

        // Mark positives
        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        // Find first missing
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }

    // 2️ Binary Search for target index
    public static int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1};
        int target = 4;

        // Linear Search result
        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive: " + missing);

        // Sort before Binary Search
        Arrays.sort(arr);

        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}

