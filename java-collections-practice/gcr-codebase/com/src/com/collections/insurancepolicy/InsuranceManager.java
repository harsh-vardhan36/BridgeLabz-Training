package com.collections.insurancepolicy;

import java.time.LocalDate;
import java.util.*;

public class InsuranceManager {

    public static Set<Policy> hashSet = new HashSet<>();
    public static Set<Policy> linkedHashSet = new LinkedHashSet<>();
    public static Set<Policy> treeSet =
            new TreeSet<>(Comparator.comparing(p -> p.expiryDate));

    public static void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    public static void displayAll(Set<Policy> set) {
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    public static void expiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (Policy p : hashSet) {
            if (!p.expiryDate.isBefore(today) &&
                !p.expiryDate.isAfter(limit)) {
                System.out.println(p);
            }
        }
    }

    public static void byCoverage(String type) {
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public static void findDuplicates(List<Policy> list) {
        Set<Integer> seen = new HashSet<>();
        for (Policy p : list) {
            if (!seen.add(p.policyNumber)) {
                System.out.println("Duplicate: " + p);
            }
        }
    }

    public static void performanceTest(Set<Policy> set, Policy p) {

        long start, end;

        start = System.nanoTime();
        set.add(p);
        end = System.nanoTime();
        System.out.println("Add Time: " + (end - start));

        start = System.nanoTime();
        set.contains(p);
        end = System.nanoTime();
        System.out.println("Search Time: " + (end - start));

        start = System.nanoTime();
        set.remove(p);
        end = System.nanoTime();
        System.out.println("Remove Time: " + (end - start));
    }
}
