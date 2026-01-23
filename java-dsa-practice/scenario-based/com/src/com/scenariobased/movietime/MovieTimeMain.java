package com.scenariobased.movietime;

public class MovieTimeMain {

    public static void main(String[] args) {

        Show[] shows = {
            new Show("Avengers", 600),   // 10:00
            new Show("Inception", 780),  
            new Show("Interstellar", 900), 
            new Show("Joker", 690)       
        };

        InsertionSortUtil.insertionSort(shows);

        System.out.println("Today's Show Schedule:");
        for (Show s : shows) {
            System.out.println(s.movieName + " at " + formatTime(s.time));
        }
    }

    private static String formatTime(int minutes) {
        int hrs = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hrs, mins);
    }
}
