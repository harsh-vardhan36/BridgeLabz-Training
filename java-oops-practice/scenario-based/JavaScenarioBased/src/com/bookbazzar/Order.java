package com.bookbazzar;

import java.util.HashMap;

class Order {

    private String userName;
    private HashMap<Book, Integer> items;
    private boolean completed; // 🔐 internal only

    public Order(String userName) {
        this.userName = userName;
        this.items = new HashMap<>();
        this.completed = false;
    }

    public void addBook(Book book, int qty) {
        if (book.isAvailable(qty)) {
            items.put(book, qty);
            book.reduceStock(qty);
        } else {
            System.out.println("❌ Not enough stock!");
        }
    }

    public double calculateTotal() {
        double total = 0;

        for (Book book : items.keySet()) {
            int qty = items.get(book);
            double cost = book.getPrice() * qty;
            total += book.applyDiscount(cost);
        }
        return total;
    }

    protected void completeOrder() {
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
