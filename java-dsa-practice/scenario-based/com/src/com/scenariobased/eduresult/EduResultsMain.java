package com.scenariobased.eduresult;

public class EduResultsMain {

    public static void main(String[] args) {

        Student[] students = {
            new Student("Aman", 72),
            new Student("Riya", 65),
            new Student("Kunal", 85),
            new Student("Neha", 60),
            new Student("Pooja", 72),
            new Student("Arjun", 90)
        };

        MergeSortUtil.mergeSort(students, 0, students.length - 1);

        System.out.println("Final State-wise Rank List:");
        for (Student s : students) {
            System.out.println(s.name + " -> " + s.marks);
        }
    }
}
