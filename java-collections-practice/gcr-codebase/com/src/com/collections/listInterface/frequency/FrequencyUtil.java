package com.collections.listInterface.frequency;

import java.util.*;

public class FrequencyUtil {

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String item : list) {
            if (freqMap.containsKey(item)) {
                freqMap.put(item, freqMap.get(item) + 1);
            } else {
                freqMap.put(item, 1);
            }
        }
        return freqMap;
    }
}
