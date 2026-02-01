package com.java8.collectors.orderrevenue;

import java.util.*;
import java.util.stream.*;

public class OrderRevenueSummary {
    public static void main(String[] args) {

        List<Order> orders = List.of(
            new Order("Amit", 2500),
            new Order("Riya", 1800),
            new Order("Amit", 3200),
            new Order("Karan", 1500),
            new Order("Riya", 2200)
        );

        Map<String, Double> revenuePerCustomer =
                orders.stream()
                      .collect(Collectors.groupingBy(
                          Order::getCustomer,
                          Collectors.summingDouble(Order::getTotal)
                      ));

        revenuePerCustomer.forEach((customer, total) ->
            System.out.println(customer + " → Total Revenue: ₹" + total)
        );
    }
}
