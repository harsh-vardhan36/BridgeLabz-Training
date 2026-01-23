package com.scenariobased.binarysearchtree.universityrecord;

public class StudentNode {
    int rollNo;
    String name;
    StudentNode left, right;

    public StudentNode(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.left = null;
        this.right = null;
    }
}
