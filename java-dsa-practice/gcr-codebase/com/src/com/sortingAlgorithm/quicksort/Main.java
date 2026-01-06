package com.sortingAlgorithm.quicksort;

class Main {
    public static void main(String[] args) {

        int[] productPrices = {999, 299, 799, 199, 499};

        QuickSort.sort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices (Ascending Order):");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }
    }
}
