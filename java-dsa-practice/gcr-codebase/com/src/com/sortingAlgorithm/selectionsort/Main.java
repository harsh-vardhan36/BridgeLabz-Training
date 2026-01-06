package com.sortingAlgorithm.selectionsort;

class Main {
    public static void main(String[] args) {

        int[] examScores = {72, 88, 64, 91, 70};

        SelectionSort.sort(examScores);

        System.out.println("Sorted Exam Scores (Ascending Order):");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }
}
