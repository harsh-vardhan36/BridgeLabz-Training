package com.sortingAlgorithm.countingsort;

class Main {
    public static void main(String[] args) {

        int[] studentAges = {15, 12, 18, 10, 14, 12, 16, 15};

        CountingSort.sort(studentAges);

        System.out.println("Sorted Student Ages (Ascending Order):");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }
}
