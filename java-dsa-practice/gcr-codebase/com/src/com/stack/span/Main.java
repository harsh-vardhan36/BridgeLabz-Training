package com.stack.span;

public class Main {
    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] span = StockSpan.calculateSpan(prices);

        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
