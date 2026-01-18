package com.scenariobased.cinemahouse;

public class ShowTimeSorter {

    public void bubbleSort(int[] showTimes) {
        int n = showTimes.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (showTimes[j] > showTimes[j + 1]) {
                    int temp = showTimes[j];
                    showTimes[j] = showTimes[j + 1];
                    showTimes[j + 1] = temp;
                }
            }
        }
    }

    public void display(int[] showTimes) {
        for (int time : showTimes) {
            System.out.print(time + " ");
        }
        System.out.println();
    }
}
