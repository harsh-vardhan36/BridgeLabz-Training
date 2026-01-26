package com.medinventory;

import java.time.LocalDate;

public class InventoryItem<T> {
    private String itemId;
    private String name;
    private int quantity;
    private LocalDate expiryDate;
    private T type;

    public InventoryItem(String itemId, String name,
                         int quantity, LocalDate expiryDate, T type) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.type = type;
    }

    public String getItemId() { return itemId; }
    public int getQuantity() { return quantity; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public T getType() { return type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryItem)) return false;
        InventoryItem<?> that = (InventoryItem<?>) o;
        return itemId.equals(that.itemId);
    }

    @Override
    public int hashCode() {
        return itemId.hashCode();
    }

    @Override
    public String toString() {
        return itemId + " | " + name +
               " | Qty: " + quantity +
               " | Exp: " + expiryDate;
    }
}
