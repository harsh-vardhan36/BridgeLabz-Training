package com.java8.stream.stockprice;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Stock> liveFeed = List.of(
            new Stock("TCS", 3890.50),
            new Stock("INFY", 1562.75),
            new Stock("RELIANCE", 2874.20)
        );

        liveFeed.stream()
                .forEach(stock -> 
                    System.out.println("Live Update: " + stock)
                );
    }
}
