package com.mapinterface.invertmap;

import java.util.*;

public class MapInverter {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {

        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {

            K key = entry.getKey();
            V value = entry.getValue();

            invertedMap
                .computeIfAbsent(value, v -> new ArrayList<>())
                .add(key);
        }

        return invertedMap;
    }
}
