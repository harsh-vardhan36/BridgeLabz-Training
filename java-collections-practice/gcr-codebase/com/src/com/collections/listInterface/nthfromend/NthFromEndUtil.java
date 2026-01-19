package com.collections.listInterface.nthfromend;

import java.util.LinkedList;

public class NthFromEndUtil {

    public static String findNthFromEnd(LinkedList<String> list, int n) {
        int first = 0;
        int second = 0;

        for (int i = 0; i < n; i++) {
            if (first >= list.size()) {
                return null;
            }
            first++;
        }

        while (first < list.size()) {
            first++;
            second++;
        }

        return list.get(second);
    }
}
