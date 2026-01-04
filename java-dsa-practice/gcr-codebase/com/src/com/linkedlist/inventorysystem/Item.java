package com.linkedlist.inventorysystem;

public class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;

    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}
