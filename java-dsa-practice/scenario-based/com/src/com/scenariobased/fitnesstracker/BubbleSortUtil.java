package com.scenariobased.fitnesstracker;

public class BubbleSortUtil {

    public static void bubbleSort(User[] users) {
        int n = users.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (users[j].steps < users[j + 1].steps) { // descending order
                    swap(users, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) break; // already sorted
        }
    }

    private static void swap(User[] users, int i, int j) {
        User temp = users[i];
        users[i] = users[j];
        users[j] = temp;
    }
}
