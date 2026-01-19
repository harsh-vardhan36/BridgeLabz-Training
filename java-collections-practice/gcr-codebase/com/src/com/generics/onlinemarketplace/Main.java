package com.generics.onlinemarketplace;

public class Main {
    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Basics", 500, new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 800, new ClothingCategory());

        Product<GadgetCategory> phone =
                new Product<>("Smartphone", 15000, new GadgetCategory());

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(phone, 5);

        Catalog catalog = new Catalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        catalog.displayCatalog();
    }
}
