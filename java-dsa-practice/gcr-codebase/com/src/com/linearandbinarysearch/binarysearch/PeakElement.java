package com.linearandbinarysearch.binarysearch;

public class PeakElement {

    public static int findPeakElement(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // If mid is smaller than next element, peak is on right side
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            // Otherwise, peak is on left side (including mid)
            else {
                right = mid;
            }
        }

        // left == right is a peak index
        return left;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeakElement(arr);

        System.out.println("Peak index: " + peakIndex);
        System.out.println("Peak element: " + arr[peakIndex]);
    }
}
