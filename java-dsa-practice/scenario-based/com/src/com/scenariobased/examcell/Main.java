package com.scenariobased.examcell;

public class Main {
    public static void main(String[] args) {

        Student[] students = {
            new Student("Aman", 92),
            new Student("Riya", 85),
            new Student("Karan", 78),
            new Student("Neha", 96),
            new Student("Sahil", 88)
        };

        ExamCell cell = new ExamCell();
        cell.mergeSort(students, 0, students.length - 1);
        cell.displayRanks(students);
    }
}
