package com.sortingAlgorithm.heapsort;

class Main {
    public static void main(String[] args) {

        int[] salaryDemands = {60000, 45000, 80000, 30000, 70000};

        HeapSort.sort(salaryDemands);

        System.out.println("Sorted Salary Demands (Ascending Order):");
        for (int salary : salaryDemands) {
            System.out.print(salary + " ");
        }
    }
}
