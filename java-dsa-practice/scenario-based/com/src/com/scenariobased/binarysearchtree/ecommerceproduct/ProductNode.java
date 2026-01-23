package com.scenariobased.binarysearchtree.ecommerceproduct;

public class ProductNode {
    int sku;
    String name;
    double price;
    ProductNode left, right;

    public ProductNode(int sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.left = null;
        this.right = null;
    }
}
