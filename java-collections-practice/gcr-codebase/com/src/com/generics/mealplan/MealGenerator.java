package com.generics.mealplan;

class MealGenerator {

    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {

        if (plan.getCalories() < 400) {
            throw new IllegalArgumentException("Calories too low!");
        }

        return new Meal<>(plan);
    }
}
