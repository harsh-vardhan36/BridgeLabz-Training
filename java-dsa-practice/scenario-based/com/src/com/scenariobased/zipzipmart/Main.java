package com.scenariobased.zipzipmart;

public class Main {
    public static void main(String[] args) {

        Sale[] sales = {
            new Sale("2024-06-01", 500),
            new Sale("2024-05-30", 1200),
            new Sale("2024-06-01", 300),
            new Sale("2024-05-29", 800)
        };

        SalesReport report = new SalesReport();
        report.mergeSort(sales, 0, sales.length - 1);
        report.display(sales);
    }
}
