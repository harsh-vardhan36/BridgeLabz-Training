package com.collections.listInterface.rotate;

import java.util.List;

public class RotateUtil {

    public static void rotateLeft(List<Integer> list, int k) {
        int n = list.size();

        k = k % n;

        for (int i = 0; i < k; i++) {
            int first = list.get(0);
            list.remove(0);
            list.add(first);
        }
    }
}
