package com.medinventory;

import java.time.LocalDate;
import java.util.*;

public class InventoryAnalyzer {

    public static <T> Map<String, List<InventoryItem<T>>> categorize(
            Set<InventoryItem<T>> items)
            throws LowStockException {

        Map<String, List<InventoryItem<T>>> map = new HashMap<>();

        for (InventoryItem<T> item : items) {

            if (item.getQuantity() < 5)
                throw new LowStockException(
                        "CRITICAL LOW STOCK: " + item.getItemId());

            map.computeIfAbsent(
                    item.getType().toString(),
                    k -> new ArrayList<>()).add(item);
        }
        return map;
    }

    public static <T> void printExpired(Set<InventoryItem<T>> items) {
        LocalDate today = LocalDate.now();

        System.out.println("Expired Items:");
        items.stream()
                .filter(i -> i.getExpiryDate().isBefore(today))
                .forEach(System.out::println);
    }
}
