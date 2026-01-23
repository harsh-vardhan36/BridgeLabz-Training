package com.scenariobased.binarysearchtree.universityrecord;

public class UniversityMain {

    public static void main(String[] args) {

        BST bst = new BST();

        // Insertion
        bst.insert(105, "Aman");
        bst.insert(102, "Riya");
        bst.insert(108, "Kunal");
        bst.insert(101, "Neha");
        bst.insert(110, "Arjun");

        // Search
        System.out.println("Searching roll no 102:");
        StudentNode s = bst.search(102);
        if (s != null)
            System.out.println("Found: " + s.name);
        else
            System.out.println("Not Found");

        // Deletion
        bst.delete(105);

        // Sorted Attendance List
        System.out.println("\nSorted Roll Numbers:");
        bst.inorder();
    }
}
