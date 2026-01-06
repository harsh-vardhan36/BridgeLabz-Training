package com.sortingAlgorithm.heapsort;

class HeapSort {

    public static void sort(int[] salaries) {
        int n = salaries.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            heapify(salaries, i, 0);
        }
    }

    private static void heapify(int[] salaries, int size, int root) {

        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && salaries[left] > salaries[largest]) {
            largest = left;
        }

        if (right < size && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != root) {
            int temp = salaries[root];
            salaries[root] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, size, largest);
        }
    }
}
