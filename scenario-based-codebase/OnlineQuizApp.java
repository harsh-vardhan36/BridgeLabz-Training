import java.util.Scanner;

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Store questions and answers
        String[] questions = {
            "Q1. What is the capital of India?",
            "Q2. Which language is used for Android development?",
            "Q3. Who is known as the father of Java?",
            "Q4. Which keyword is used to inherit a class?",
            "Q5. Which data type is used for decimal values?"
        };

        String[][] options = {
            {"A. Delhi", "B. Mumbai", "C. Kolkata", "D. Chennai"},
            {"A. Python", "B. Java", "C. C++", "D. Kotlin"},
            {"A. James Gosling", "B. Dennis Ritchie", "C. Bjarne Stroustrup", "D. Guido van Rossum"},
            {"A. this", "B. extends", "C. implements", "D. super"},
            {"A. int", "B. double", "C. char", "D. boolean"}
        };

        char[] answers = {'A', 'D', 'A', 'B', 'B'}; // correct answers

        int score = 0;

        // Step 2: Loop through questions
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String opt