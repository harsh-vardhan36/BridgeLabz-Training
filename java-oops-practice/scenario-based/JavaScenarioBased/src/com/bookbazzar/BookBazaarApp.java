package com.bookbazzar;

public class BookBazaarApp {
    public static void main(String[] args) {

        Book ebook = new EBook(
                "Atomic Habits",
                "James Clear",
                500
        );

        Book printed = new PrintedBook(
                "Clean Code",
                "Robert C. Martin",
                800,
                5
        );

        Order order = new Order("Harsh");

        order.addBook(ebook, 2);
        order.addBook(printed, 1);

        System.out.println("Total Amount: ₹" +
                order.calculateTotal());
    }
}
