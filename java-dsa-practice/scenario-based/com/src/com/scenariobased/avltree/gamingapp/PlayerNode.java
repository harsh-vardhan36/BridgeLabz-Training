package com.scenariobased.avltree.gamingapp;

public class PlayerNode {
    String name;
    int score;
    int height;

    PlayerNode left, right;

    public PlayerNode(String name, int score) {
        this.name = name;
        this.score = score;
        this.height = 1;
    }
}
