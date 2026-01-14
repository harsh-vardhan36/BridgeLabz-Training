package com.scenariobased.examproctor;
public class Main {
    public static void main(String[] args) {

        ExamProctor exam = new ExamProctor();

        exam.setCorrectAnswer(1, "A");
        exam.setCorrectAnswer(2, "B");
        exam.setCorrectAnswer(3, "C");

        
        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");

        exam.visitQuestion(2);
        exam.submitAnswer(2, "C");

        exam.visitQuestion(3);
        exam.submitAnswer(3, "C");

        
        int score = exam.calculateScore();
        System.out.println("Final Score: " + score);
    }
}
