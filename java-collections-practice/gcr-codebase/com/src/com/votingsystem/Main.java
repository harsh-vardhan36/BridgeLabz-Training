package com.votingsystem;

public class Main {

    public static void main(String[] args) {

        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Carol");
        system.castVote("Bob");

        System.out.println(" Votes in insertion order:");
        System.out.println(system.getVotesInInsertionOrder());

        System.out.println("\n Votes in sorted order:");
        System.out.println(system.getVotesInSortedOrder());
    }
}
