package com.generics.mealplan;

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public void showMeal() {
        System.out.println(
            mealPlan.getMealType() + " Meal | Calories: " + mealPlan.getCalories()
        );
    }
}
