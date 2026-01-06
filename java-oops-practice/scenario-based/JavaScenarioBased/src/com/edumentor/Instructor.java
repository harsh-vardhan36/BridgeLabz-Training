package com.edumentor;

public class Instructor extends User {

    public Instructor(String name, String userId, String email) {
        super(name, userId, email);
    }

    public Quiz createQuiz(String difficulty) {
        return new Quiz(difficulty);
    }

    public void assignQuiz(Learner learner, Quiz quiz) {
        learner.receiveQuiz(quiz);
    }
}
