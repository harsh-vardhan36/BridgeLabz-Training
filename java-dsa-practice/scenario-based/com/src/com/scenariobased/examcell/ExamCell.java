package com.scenariobased.examcell;

class ExamCell {

    void mergeSort(Student[] students, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(students, left, mid);
            mergeSort(students, mid + 1, right);

            merge(students, left, mid, right);
        }
    }

    void merge(Student[] students, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; i++)
            L[i] = students[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = students[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Sort by score (descending)
        while (i < n1 && j < n2) {
            if (L[i].score >= R[j].score) {
                students[k++] = L[i++];
            } else {
                students[k++] = R[j++];
            }
        }

        while (i < n1)
            students[k++] = L[i++];

        while (j < n2)
            students[k++] = R[j++];
    }

    void displayRanks(Student[] students) {
        int rank = 1;
        for (Student s : students) {
            System.out.println(
                "Rank " + rank++ + ": " + s.name + " - " + s.score
            );
        }
    }
}
