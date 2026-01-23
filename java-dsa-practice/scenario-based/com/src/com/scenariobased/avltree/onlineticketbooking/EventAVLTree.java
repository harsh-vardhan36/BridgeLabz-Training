package com.scenariobased.avltree.onlineticketbooking;

public class EventAVLTree {

    EventNode root;

    int height(EventNode n) {
        return n == null ? 0 : n.height;
    }

    int getBalance(EventNode n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    EventNode rightRotate(EventNode y) {
        EventNode x = y.left;
        EventNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    EventNode leftRotate(EventNode x) {
        EventNode y = x.right;
        EventNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert event
    public EventNode insert(EventNode node, String name, int time) {
        if (node == null)
            return new EventNode(name, time);

        if (time < node.startTime)
            node.left = insert(node.left, name, time);
        else if (time > node.startTime)
            node.right = insert(node.right, name, time);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // LL
        if (balance > 1 && time < node.left.startTime)
            return rightRotate(node);

        // RR
        if (balance < -1 && time > node.right.startTime)
            return leftRotate(node);

        // LR
        if (balance > 1 && time > node.left.startTime) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && time < node.right.startTime) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Delete event
    public EventNode delete(EventNode root, int time) {
        if (root == null) return root;

        if (time < root.startTime)
            root.left = delete(root.left, time);
        else if (time > root.startTime)
            root.right = delete(root.right, time);
        else {
            if ((root.left == null) || (root.right == null)) {
                EventNode temp = (root.left != null) ? root.left : root.right;
                if (temp == null) root = null;
                else root = temp;
            } else {
                EventNode temp = minValueNode(root.right);
                root.startTime = temp.startTime;
                root.eventName = temp.eventName;
                root.right = delete(root.right, temp.startTime);
            }
        }

        if (root == null) return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        // LL
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // LR
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // RL
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    EventNode minValueNode(EventNode node) {
        EventNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Inorder traversal
    public void inorder(EventNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.eventName + " at " + formatTime(node.startTime));
            inorder(node.right);
        }
    }

    private String formatTime(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}
