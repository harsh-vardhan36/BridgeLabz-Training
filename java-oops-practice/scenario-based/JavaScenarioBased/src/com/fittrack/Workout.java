package com.fittrack;

public abstract class Workout implements ITrackable {
    protected String type;
    protected int duration; 
    protected int caloriesBurned;
    private boolean active;

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    public abstract void calculateCalories();

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    @Override
    public void startWorkout() {
        active = true;
        System.out.println(type + " workout started");
    }

    @Override
    public void stopWorkout() {
        active = false;
        calculateCalories();
        System.out.println(type + " workout stopped");
    }
}
