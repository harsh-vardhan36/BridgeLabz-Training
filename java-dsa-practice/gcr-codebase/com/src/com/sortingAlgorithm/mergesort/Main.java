package com.sortingAlgorithm.mergesort;

class Main {
    public static void main(String[] args) {

        int[] bookPrices = {450, 299, 799, 199, 599};

        MergeSort.sort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted Book Prices (Ascending Order):");
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }
    }
}
