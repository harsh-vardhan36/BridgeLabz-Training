package com.insurancepolicy;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy(
                101, "Alice",
                LocalDate.now().plusDays(10),
                "Health", 5000));

        manager.addPolicy(new Policy(
                102, "Bob",
                LocalDate.now().plusDays(40),
                "Auto", 3000));

        manager.addPolicy(new Policy(
                103, "Alice",
                LocalDate.now().minusDays(5),
                "Home", 7000));

        System.out.println("🔍 Policy 101:");
        System.out.println(manager.getPolicyByNumber(101));

        System.out.println("\n⏰ Expiring in 30 days:");
        System.out.println(manager.getPoliciesExpiringIn30Days());

        System.out.println("\n👤 Policies for Alice:");
        System.out.println(manager.getPoliciesByHolder("Alice"));

        manager.removeExpiredPolicies();
    }
}
