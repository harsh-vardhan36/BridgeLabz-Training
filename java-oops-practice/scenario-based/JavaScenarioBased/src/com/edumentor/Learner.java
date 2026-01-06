package com.edumentor;

public class Learner extends User implements ICertifiable {

    private Quiz currentQuiz;
    private int quizzesAttempted;
    private double lastScorePercentage;

    public Learner(String name, String userId, String email) {
        super(name, userId, email);
        this.quizzesAttempted = 0;
    }

    public void takeQuiz(Quiz quiz, String[] userAnswers) {
        this.currentQuiz = quiz;
        quizzesAttempted++;
        lastScorePercentage = quiz.evaluate(userAnswers);
    }
    public void receiveQuiz(Quiz quiz) {
        this.currentQuiz = quiz;
    }

    public int getQuizzesAttempted() {
        return quizzesAttempted;
    }
    
    public double getLastScorePercentage() {
        return lastScorePercentage;
    }

    @Override
    public String generateCertificate() {
        return "Certificate generated for learner: " + name +
               " | Score: " + lastScorePercentage + "%";
    }
}
