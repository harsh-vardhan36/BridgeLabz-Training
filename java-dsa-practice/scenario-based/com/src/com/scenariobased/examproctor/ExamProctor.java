package com.scenariobased.examproctor;
import java.util.*;

class ExamProctor {

    Stack<Integer> navigationStack = new Stack<>();
    HashMap<Integer, String> studentAnswers = new HashMap<>();
    HashMap<Integer, String> correctAnswers = new HashMap<>();

    
    void visitQuestion(int qId) {
        navigationStack.push(qId);
        System.out.println("Visited Question: " + qId);
    }

    
    void submitAnswer(int qId, String answer) {
        studentAnswers.put(qId, answer);
    }

    
    void setCorrectAnswer(int qId, String answer) {
        correctAnswers.put(qId, answer);
    }

    int calculateScore() {
        int score = 0;

        for (int qId : correctAnswers.keySet()) {
            if (studentAnswers.containsKey(qId) &&
                studentAnswers.get(qId).equals(correctAnswers.get(qId))) {
                score++;
            }
        }
        return score;
    }
}
