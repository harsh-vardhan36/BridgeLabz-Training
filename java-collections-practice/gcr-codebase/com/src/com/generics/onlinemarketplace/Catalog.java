package com.generics.onlinemarketplace;

import java.util.*;

class Catalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void displayCatalog() {
        for (Product<? extends Category> p : products) {
            System.out.println(p.getDetails());
        }
    }
}
