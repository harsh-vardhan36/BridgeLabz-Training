package com.medinventory;

import java.util.*;

public class Main{
    public static void main(String[] args) {

        try {
            Set<InventoryItem<String>> items =
                    InventoryReader.readInventory(
                            "inventory.csv", "MedicalSupply");

            InventoryAnalyzer.printExpired(items);

            Map<String, List<InventoryItem<String>>> categorized =
                    InventoryAnalyzer.categorize(items);

            categorized.forEach((k, v) -> {
                System.out.println("\nCategory: " + k);
                v.forEach(System.out::println);
            });

        } catch (LowStockException e) {
            System.out.println(e.getMessage());
        }
    }
}
