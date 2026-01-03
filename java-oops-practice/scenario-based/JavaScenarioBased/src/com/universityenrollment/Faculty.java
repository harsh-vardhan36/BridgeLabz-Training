package com.universityenrollment;

class Faculty implements Graded {

    private String facultyName;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public void assignGrade(char grade) {
        System.out.println("Grade Assigned : " + grade +
                " by " + facultyName);
    }

    public void evaluateStudent(Student student, double score) {

        if (student.isEnrolled()) {
            System.out.println("ERROR: Student not enrolled");
            return;
        }

        char grade;
        if (score >= 9) grade = 'A';
        else if (score >= 8) grade = 'B';
        else if (score >= 7) grade = 'C';
        else grade = 'D';

        student.updateGpa(score);
        student.setGrade(grade);
        assignGrade(grade);
    }
}