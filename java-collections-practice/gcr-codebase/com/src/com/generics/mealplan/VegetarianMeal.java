package com.generics.mealplan;

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }

    public int getCalories() {
        return 500;
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }

    public int getCalories() {
        return 450;
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }

    public int getCalories() {
        return 600;
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }

    public int getCalories() {
        return 700;
    }
}
