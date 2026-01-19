package com.collections.listInterface.reverse;

import java.util.List;

public class ReverseUtil {

    public static void reverseList(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }
    }
}
