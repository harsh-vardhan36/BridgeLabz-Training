package com.bookbazzar;

abstract class Book implements IDiscountable {

    protected String title;
    protected String author;
    protected double price;

    private int stock; // inventory protected

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    // Optional offer constructor
    public Book(String title, String author, double price) {
        this(title, author, price, 10); // default stock
    }

    public boolean isAvailable(int qty) {
        return stock >= qty;
    }

    protected void reduceStock(int qty) {
        if (qty <= stock) {
            stock -= qty;
        }
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }
}

