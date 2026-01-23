package com.scenariobased.flashdealz;

public class FlashDealzMain {

    public static void main(String[] args) {

        Product[] products = {
            new Product("Laptop", 30),
            new Product("Mobile", 70),
            new Product("Headphones", 20),
            new Product("Smart TV", 90),
            new Product("Watch", 50)
        };

        QuickSortUtil.quickSort(products, 0, products.length - 1);

        System.out.println("Top Discounted Products:");
        for (Product p : products) {
            System.out.println(p.name + " -> " + p.discount + "%");
        }
    }
}
