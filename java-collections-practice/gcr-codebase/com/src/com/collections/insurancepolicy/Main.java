package com.collections.insurancepolicy;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Policy p1 = new Policy(101, "Amit",
                LocalDate.now().plusDays(10), "Health", 5000);

        Policy p2 = new Policy(102, "Riya",
                LocalDate.now().plusDays(40), "Auto", 3000);

        Policy p3 = new Policy(103, "John",
                LocalDate.now().plusDays(5), "Home", 7000);

        Policy p4 = new Policy(101, "Amit Duplicate",
                LocalDate.now().plusDays(15), "Health", 5200);

        InsuranceManager.addPolicy(p1);
        InsuranceManager.addPolicy(p2);
        InsuranceManager.addPolicy(p3);
        InsuranceManager.addPolicy(p4);

        System.out.println("=== All Policies (TreeSet) ===");
        InsuranceManager.displayAll(InsuranceManager.treeSet);

        System.out.println("\n=== Expiring in 30 Days ===");
        InsuranceManager.expiringSoon();

        System.out.println("\n=== Health Policies ===");
        InsuranceManager.byCoverage("Health");

        System.out.println("\n=== Duplicate Policies ===");
        List<Policy> list = Arrays.asList(p1, p2, p3, p4);
        InsuranceManager.findDuplicates(list);

        System.out.println("\n=== Performance Test (HashSet) ===");
        InsuranceManager.performanceTest(
                new HashSet<>(InsuranceManager.hashSet), p1);
    }
}
