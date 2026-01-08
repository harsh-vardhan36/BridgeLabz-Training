package com.linearandbinarysearch.binarysearch;

public class RotationPoint {

    public static int findRotationIndex(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        // Binary search
        while (left < right) {

            int mid = left + (right - left) / 2;

            // Smallest element is in right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Smallest element is in left half (including mid)
            else {
                right = mid;
            }
        }

        // left == right -> index of smallest element
        return left;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 1, 2, 3};

        int index = findRotationIndex(arr);

        System.out.println("Rotation index: " + index);
        System.out.println("Smallest element: " + arr[index]);
    }
}
