package com.scenariobased.cropmonitor;

public class SensorSorter {

    // Quick Sort method
    public void quickSort(int[] timestamps, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(timestamps, low, high);

            quickSort(timestamps, low, pivotIndex - 1);
            quickSort(timestamps, pivotIndex + 1, high);
        }
    }

   
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];   
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    
    public void display(int[] timestamps) {
        for (int t : timestamps) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
