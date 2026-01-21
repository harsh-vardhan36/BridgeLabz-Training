package com.insurancepolicy;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    private Map<Integer, Policy> hashMap = new HashMap<>();
    private Map<Integer, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    //  Add Policy
    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);

        treeMap
            .computeIfAbsent(policy.getExpiryDate(),
                             d -> new ArrayList<>())
            .add(policy);
    }

    //  Retrieve by Policy Number
    public Policy getPolicyByNumber(int policyNumber) {
        return hashMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringIn30Days() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        List<Policy> result = new ArrayList<>();

        for (Map.Entry<LocalDate, List<Policy>> entry :
                treeMap.subMap(today, true, limit, true).entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    public List<Policy> getPoliciesByHolder(String name) {
        List<Policy> result = new ArrayList<>();

        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(name)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<Integer, Policy>> it =
                hashMap.entrySet().iterator();

        while (it.hasNext()) {
            Policy policy = it.next().getValue();
            if (policy.getExpiryDate().isBefore(today)) {
                it.remove();
                linkedHashMap.remove(policy.getPolicyNumber());
                treeMap.get(policy.getExpiryDate()).remove(policy);
            }
        }
    }
}
