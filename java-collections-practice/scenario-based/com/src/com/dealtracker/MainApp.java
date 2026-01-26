package com.dealtracker;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        Map<String, Deal> deals =
                DealManager.loadDeals("deals");

        List<Deal> sorted =
                DealManager.sortByDiscount(deals.values());

        System.out.println("Valid Deals:");
        sorted.forEach(System.out::println);
    }
}
