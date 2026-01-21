package com.votingsystem;

import java.util.*;

public class VotingSystem {

    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> insertionOrderMap = new LinkedHashMap<>();

    // Cast vote
    public void castVote(String candidate) {

        voteMap.put(candidate,
                voteMap.getOrDefault(candidate, 0) + 1);

        insertionOrderMap.put(candidate,
                insertionOrderMap.getOrDefault(candidate, 0) + 1);
    }

    // Display votes in insertion order
    public Map<String, Integer> getVotesInInsertionOrder() {
        return insertionOrderMap;
    }

    // Display votes in sorted order
    public Map<String, Integer> getVotesInSortedOrder() {
        return new TreeMap<>(voteMap);
    }
}
