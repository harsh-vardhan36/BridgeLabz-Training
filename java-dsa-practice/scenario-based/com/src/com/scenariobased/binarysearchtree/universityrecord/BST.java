package com.scenariobased.binarysearchtree.universityrecord;

public class BST {
    StudentNode root;

    // Insert
    public void insert(int rollNo, String name) {
        root = insertRec(root, rollNo, name);
    }

    private StudentNode insertRec(StudentNode root, int rollNo, String name) {
        if (root == null)
            return new StudentNode(rollNo, name);

        if (rollNo < root.rollNo)
            root.left = insertRec(root.left, rollNo, name);
        else if (rollNo > root.rollNo)
            root.right = insertRec(root.right, rollNo, name);

        return root;
    }

    // Search
    public StudentNode search(int rollNo) {
        return searchRec(root, rollNo);
    }

    private StudentNode searchRec(StudentNode root, int rollNo) {
        if (root == null || root.rollNo == rollNo)
            return root;

        if (rollNo < root.rollNo)
            return searchRec(root.left, rollNo);

        return searchRec(root.right, rollNo);
    }

    // Delete
    public void delete(int rollNo) {
        root = deleteRec(root, rollNo);
    }

    private StudentNode deleteRec(StudentNode root, int rollNo) {
        if (root == null) return root;

        if (rollNo < root.rollNo)
            root.left = deleteRec(root.left, rollNo);
        else if (rollNo > root.rollNo)
            root.right = deleteRec(root.right, rollNo);
        else {
            // one or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // two children
            root.rollNo = minValue(root.right);
            root.right = deleteRec(root.right, root.rollNo);
        }
        return root;
    }

    private int minValue(StudentNode root) {
        int min = root.rollNo;
        while (root.left != null) {
            min = root.left.rollNo;
            root = root.left;
        }
        return min;
    }

    // Inorder Traversal (Sorted Output)
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(StudentNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.rollNo + " - " + root.name);
            inorderRec(root.right);
        }
    }
}
