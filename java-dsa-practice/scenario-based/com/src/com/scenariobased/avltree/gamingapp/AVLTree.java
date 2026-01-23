package com.scenariobased.avltree.gamingapp;

public class AVLTree {

    PlayerNode root;

    // Get height
    int height(PlayerNode n) {
        return n == null ? 0 : n.height;
    }

    // Balance factor
    int getBalance(PlayerNode n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    // Right rotation
    PlayerNode rightRotate(PlayerNode y) {
        PlayerNode x = y.left;
        PlayerNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotation
    PlayerNode leftRotate(PlayerNode x) {
        PlayerNode y = x.right;
        PlayerNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert / Update player (sorted by score)
    public PlayerNode insert(PlayerNode node, String name, int score) {
        if (node == null)
            return new PlayerNode(name, score);

        if (score > node.score)
            node.left = insert(node.left, name, score);
        else if (score < node.score)
            node.right = insert(node.right, name, score);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && score > node.left.score)
            return rightRotate(node);

        // RR
        if (balance < -1 && score < node.right.score)
            return leftRotate(node);

        // LR
        if (balance > 1 && score < node.left.score) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && score > node.right.score) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Reverse inorder → Top players
    public void topPlayers(PlayerNode node, int[] count) {
        if (node == null || count[0] >= 10) return;

        topPlayers(node.left, count);
        if (count[0] < 10) {
            System.out.println(node.name + " → " + node.score);
            count[0]++;
        }
        topPlayers(node.right, count);
    }
}
