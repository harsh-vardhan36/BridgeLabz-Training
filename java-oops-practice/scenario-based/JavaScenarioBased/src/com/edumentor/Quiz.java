package com.edumentor;

public class Quiz {

    private String[] questions;
    private final String[] answers;
    private int score;
    private int totalMarks;

    public Quiz(String difficulty) {

        if (difficulty.equalsIgnoreCase("easy")) {
            questions = new String[]{
                    "2 + 2 = ?",
                    "5 - 3 = ?",
                    "3 + 1 = ?"
            };
            answers = new String[]{"4", "2", "4"};
        }
        else if (difficulty.equalsIgnoreCase("medium")) {
            questions = new String[]{
                    "10 / 2 = ?",
                    "6 * 2 = ?",
                    "9 - 4 = ?",
                    "3 * 3 = ?",
                    "8 + 1 = ?"
            };
            answers = new String[]{"5", "12", "5", "9", "9"};
        }
        else {
            questions = new String[]{
                    "12 / 3 = ?",
                    "7 * 2 = ?",
                    "15 - 6 = ?",
                    "4 * 4 = ?",
                    "18 / 2 = ?",
                    "10 + 5 = ?",
                    "9 * 1 = ?"
            };
            answers = new String[]{"4", "14", "9", "16", "9", "15", "9"};
        }

        totalMarks = answers.length * 10;
    }
    public int getQuestionCount() {
        return questions.length;
    }

    public String getQuestion(int index) {
        return questions[index];
    }


    public double evaluate(String[] userAnswers) {
        score = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(userAnswers[i])) {
                score += 10;
            }
        }

        return (score * 100.0) / totalMarks;
    }
}
