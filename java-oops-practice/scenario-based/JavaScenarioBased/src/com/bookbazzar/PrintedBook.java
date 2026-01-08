package com.bookbazzar;

class PrintedBook extends Book {

    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.95; // 5% discount
    }
}

