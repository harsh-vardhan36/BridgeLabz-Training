package com.fittrack;

public class Main {
    public static void main(String[] args) {

        UserProfile user = new UserProfile("Harsh", 22, 70, "Lose Weight");

        Workout workout1 = new CardioWorkout(30);
        Workout workout2 = new StrengthWorkout(20);

        workout1.startWorkout();
        workout1.stopWorkout();

        workout2.startWorkout();
        workout2.stopWorkout();

        int totalCalories =
                workout1.getCaloriesBurned() + workout2.getCaloriesBurned();

        int remaining = user.calculateProgress(totalCalories);

        System.out.println("Goal: " + user.getGoal());
        System.out.println("Total Calories Burned: " + totalCalories);
        System.out.println("Calories Remaining Today: " + remaining);
    }
}
