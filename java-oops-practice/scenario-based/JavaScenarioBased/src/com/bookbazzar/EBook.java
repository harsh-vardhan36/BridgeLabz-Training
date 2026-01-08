package com.bookbazzar;

class EBook extends Book {

    public EBook(String title, String author, double price) {
        super(title, author, price, Integer.MAX_VALUE); // unlimited stock
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.90; // 10% discount
    }
}
