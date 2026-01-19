package com.generics.mealplan;

public class Main {
    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal =
                MealGenerator.generateMeal(new VegetarianMeal());

        Meal<VeganMeal> veganMeal =
                MealGenerator.generateMeal(new VeganMeal());

        Meal<KetoMeal> ketoMeal =
                MealGenerator.generateMeal(new KetoMeal());

        vegMeal.showMeal();
        veganMeal.showMeal();
        ketoMeal.showMeal();
    }
}
