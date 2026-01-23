package com.scenariobased.movietime;

public class InsertionSortUtil {

    public static void insertionSort(Show[] shows) {
        int n = shows.length;

        for (int i = 1; i < n; i++) {
            Show key = shows[i];
            int j = i - 1;

            while (j >= 0 && shows[j].time > key.time) {
                shows[j + 1] = shows[j];
                j--;
            }
            shows[j + 1] = key;
        }
    }
}
