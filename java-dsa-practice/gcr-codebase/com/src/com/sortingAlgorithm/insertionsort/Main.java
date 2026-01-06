package com.sortingAlgorithm.insertionsort;

class Main {
    public static void main(String[] args) {

        int[] employeeIds = {105, 101, 109, 102, 108};

        InsertionSort.sort(employeeIds);

        System.out.println("Sorted Employee IDs (Ascending Order):");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
}
