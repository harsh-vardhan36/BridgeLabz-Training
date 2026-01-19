package com.generics.smartwarehouse;

public class Main {
    public static void main(String[] args) {

        Storage<Electronics> electronicStorage = new Storage<>();
        electronicStorage.addItem(new Electronics("Laptop"));
        electronicStorage.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));

        System.out.println("Electronics:");
        WarehouseUtil.displayItems(electronicStorage.getItems());

        System.out.println("\nGroceries:");
        WarehouseUtil.displayItems(groceryStorage.getItems());
    }
}
