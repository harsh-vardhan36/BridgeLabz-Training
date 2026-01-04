package com.linkedlist.inventorysystem;

public class Main {
    public static void main(String[] args) {

        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtEnd(new Item(101, "Keyboard", 5, 700));
        inventory.addAtBeginning(new Item(102, "Mouse", 10, 300));
        inventory.addAtPosition(new Item(103, "Monitor", 3, 8000), 2);

        System.out.println("Inventory:");
        inventory.displayAll();

        inventory.updateQuantity(101, 8);

        System.out.println("\nAfter Quantity Update:");
        inventory.displayAll();

        System.out.println("\nSearch Item ID 103:");
        inventory.searchByItemId(103);

        System.out.println("\nTotal Inventory Value:");
        System.out.println(inventory.calculateTotalValue());

        inventory.sortByName(true);
        System.out.println("\nSorted by Name Ascending:");
        inventory.displayAll();

        inventory.sortByPrice(false);
        System.out.println("\nSorted by Price Descending:");
        inventory.displayAll();
    }
}
