package com.edumentor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Instructor instructor = new Instructor(
                "Dr. Sharma",
                "INS101",
                "sharma@edumentor.com"
        );

        Learner learner = new Learner(
                "Harsh",
                "LRN202",
                "harsh@gmail.com"
        );

        Quiz quiz = instructor.createQuiz("easy");

        System.out.println("Quiz Started!\n");

        String[] userAnswers = new String[quiz.getQuestionCount()];

        for (int i = 0; i < quiz.getQuestionCount(); i++) {
            System.out.println("Q" + (i + 1) + ": " + quiz.getQuestion(i));
            System.out.print("Your Answer: ");
            userAnswers[i] = sc.nextLine();
        }

        learner.takeQuiz(quiz, userAnswers);

        System.out.println("\nResult:");
        System.out.println("Score Percentage: " + learner.getLastScorePercentage());
        System.out.println(learner.generateCertificate());

        sc.close();
    }
}
