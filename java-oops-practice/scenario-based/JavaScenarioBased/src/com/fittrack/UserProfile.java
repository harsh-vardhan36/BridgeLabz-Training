package com.fittrack;

public class UserProfile {
    private String name;
    private int age;
    private double weight;
    private String goal;
    private int dailyTargetCalories = 500;
 
    public UserProfile(String name, int age, double weight) {
        this(name, age, weight, "Stay Fit");
    }

    public UserProfile(String name, int age, double weight, String goal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = goal;
    }

    public int calculateProgress(int caloriesBurned) {
        return dailyTargetCalories - caloriesBurned;
    }

    public String getGoal() {
        return goal;
    }
}
