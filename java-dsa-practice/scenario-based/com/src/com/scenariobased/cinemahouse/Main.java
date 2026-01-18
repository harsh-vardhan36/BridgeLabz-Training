package com.scenariobased.cinemahouse;

public class Main {
    public static void main(String[] args) {

        int[] showTimes = { 1800, 1400, 2100, 1200, 1600 };

        ShowTimeSorter manager = new ShowTimeSorter();

        System.out.println("Before sorting showtimes:");
        manager.display(showTimes);

        manager.bubbleSort(showTimes);

        System.out.println("After sorting showtimes:");
        manager.display(showTimes);
    }
}
