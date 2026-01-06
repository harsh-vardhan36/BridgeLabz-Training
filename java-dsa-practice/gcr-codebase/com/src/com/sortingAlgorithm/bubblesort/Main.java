package com.sortingAlgorithm.bubblesort;

class Main {
    public static void main(String[] args) {

        int[] marks = {78, 45, 90, 62, 55};

        BubbleSort.sort(marks);

        System.out.println("Sorted Marks (Ascending Order):");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}
