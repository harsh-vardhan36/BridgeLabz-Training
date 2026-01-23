package com.scenariobased.tailorshop;

public class InsertionSortUtil {

    public static void insertionSort(Order[] orders) {
        int n = orders.length;

        for (int i = 1; i < n; i++) {
            Order key = orders[i];
            int j = i - 1;

            while (j >= 0 && orders[j].deadlineDay > key.deadlineDay) {
                orders[j + 1] = orders[j];
                j--;
            }
            orders[j + 1] = key;
        }
    }
}
