package com.scenariobased.avltree.gamingapp;

public class Main {

    public static void main(String[] args) {

        AVLTree leaderboard = new AVLTree();

        leaderboard.root = leaderboard.insert(leaderboard.root, "ShadowX", 3200);
        leaderboard.root = leaderboard.insert(leaderboard.root, "Carlet", 2800);
        leaderboard.root = leaderboard.insert(leaderboard.root, "ALpha", 3500);
        leaderboard.root = leaderboard.insert(leaderboard.root, "MajorGeneral", 3000);
        leaderboard.root = leaderboard.insert(leaderboard.root, "Pixel", 2600);

        System.out.println("Top Players:");
        leaderboard.topPlayers(leaderboard.root, new int[]{0});
    }
}
