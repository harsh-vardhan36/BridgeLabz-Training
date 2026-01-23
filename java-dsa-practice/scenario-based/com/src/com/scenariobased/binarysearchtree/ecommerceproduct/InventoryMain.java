package com.scenariobased.binarysearchtree.ecommerceproduct;

public class InventoryMain {

    public static void main(String[] args) {

        ProductBST inventory = new ProductBST();

        // Insert products
        inventory.insert(1050, "Laptop", 65000);
        inventory.insert(1020, "Mouse", 700);
        inventory.insert(1080, "Keyboard", 2500);
        inventory.insert(1010, "USB Cable", 300);
        inventory.insert(1100, "Monitor", 12000);

        // Lookup
        System.out.println("Searching SKU 1080:");
        ProductNode p = inventory.search(1080);
        if (p != null)
            System.out.println("Found: " + p.name + " -> ₹" + p.price);
        else
            System.out.println("Product not found");

        // Price update
        inventory.updatePrice(1050, 62000);

        // Sorted inventory display
        System.out.println("\nSorted Product Inventory:");
        inventory.inorder();
    }
}
