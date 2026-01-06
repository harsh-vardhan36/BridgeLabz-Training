package com.sortingAlgorithm.quicksort;

class QuickSort {

    public static void sort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            sort(prices, low, pivotIndex - 1);
            sort(prices, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] prices, int low, int high) {

    	// pivot = last element
        int pivot = prices[high]; 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }
}
