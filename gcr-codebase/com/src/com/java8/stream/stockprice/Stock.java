package com.java8.stream.stockprice;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public String toString() {
        return symbol + " → ₹" + price;
    }
}

