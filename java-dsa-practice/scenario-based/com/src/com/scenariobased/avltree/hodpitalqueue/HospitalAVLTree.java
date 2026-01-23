package com.scenariobased.avltree.hodpitalqueue;

public class HospitalAVLTree {

    PatientNode root;

    int height(PatientNode n) {
        return n == null ? 0 : n.height;
    }

    int getBalance(PatientNode n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    PatientNode rightRotate(PatientNode y) {
        PatientNode x = y.left;
        PatientNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    PatientNode leftRotate(PatientNode x) {
        PatientNode y = x.right;
        PatientNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert patient
    public PatientNode insert(PatientNode node, String name, int time) {
        if (node == null)
            return new PatientNode(name, time);

        if (time < node.arrivalTime)
            node.left = insert(node.left, name, time);
        else if (time > node.arrivalTime)
            node.right = insert(node.right, name, time);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // LL
        if (balance > 1 && time < node.left.arrivalTime)
            return rightRotate(node);

        // RR
        if (balance < -1 && time > node.right.arrivalTime)
            return leftRotate(node);

        // LR
        if (balance > 1 && time > node.left.arrivalTime) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && time < node.right.arrivalTime) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Delete patient (discharge)
    public PatientNode delete(PatientNode root, int time) {
        if (root == null) return root;

        if (time < root.arrivalTime)
            root.left = delete(root.left, time);
        else if (time > root.arrivalTime)
            root.right = delete(root.right, time);
        else {
            if (root.left == null || root.right == null) {
                PatientNode temp = (root.left != null) ? root.left : root.right;
                root = (temp == null) ? null : temp;
            } else {
                PatientNode temp = minValueNode(root.right);
                root.arrivalTime = temp.arrivalTime;
                root.patientName = temp.patientName;
                root.right = delete(root.right, temp.arrivalTime);
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

    PatientNode minValueNode(PatientNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // Display patients by arrival time
    public void inorder(PatientNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.patientName + " → Arrived at " + formatTime(node.arrivalTime));
            inorder(node.right);
        }
    }

    private String formatTime(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}
