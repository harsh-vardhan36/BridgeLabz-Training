package com.shoppingcart;

import java.util.*;

public class ShoppingCart {

    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Double> insertionOrderMap = new LinkedHashMap<>();

    // Add product to cart
    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        insertionOrderMap.put(product, price);
    }

    // View cart in insertion order
    public Map<String, Double> viewCartInOrder() {
        return insertionOrderMap;
    }

    // View cart sorted by price
    public Map<Double, List<String>> viewCartSortedByPrice() {

        Map<Double, List<String>> sortedMap = new TreeMap<>();

        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {

            sortedMap
                .computeIfAbsent(entry.getValue(),
                                 p -> new ArrayList<>())
                .add(entry.getKey());
        }
        return sortedMap;
    }
}
