package com.queue.greedy;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    public static int findStart(PetrolPump[] pumps) {

        Queue<Integer> queue = new LinkedList<>();
        int currentPetrol = 0;
        int i = 0;
        int n = pumps.length;

        while (queue.size() < n) {

            currentPetrol += pumps[i].petrol - pumps[i].distance;
            queue.offer(i);

            while (currentPetrol < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                currentPetrol -= pumps[removed].petrol - pumps[removed].distance;
            }

            i = (i + 1) % n;

            if (queue.isEmpty() && i == 0) {
                return -1;
            }
        }

        return queue.peek();
    }
}
