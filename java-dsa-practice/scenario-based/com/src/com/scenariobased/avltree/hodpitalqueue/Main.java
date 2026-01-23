package com.scenariobased.avltree.hodpitalqueue;

public class Main {

    public static void main(String[] args) {

        HospitalAVLTree tree = new HospitalAVLTree();

        tree.root = tree.insert(tree.root, "Aman", 540);   // 09:00
        tree.root = tree.insert(tree.root, "Riya", 570);   // 09:30
        tree.root = tree.insert(tree.root, "Kunal", 600);  // 10:00
        tree.root = tree.insert(tree.root, "Neha", 555);   // 09:15

        tree.root = tree.delete(tree.root, 570);

        // Display queue
        System.out.println("Patient Queue (By Arrival Time):");
        tree.inorder(tree.root);
    }
}
