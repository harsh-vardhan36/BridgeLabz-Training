package com.ecowing;
import java.util.*;

class BirdSanctuary {

    private List<Bird> birds = new ArrayList<>();

    public void addBird(Bird bird) {
        birds.add(bird);
    }

    public void removeBird(String id) {
        birds.removeIf(b -> b.getId().equals(id));
    }

    public void displayAllBirds() {
        for (Bird b : birds) {
            b.displayInfo();
            b.eat();

            if (b instanceof Flyable)
                ((Flyable) b).fly();

            if (b instanceof Swimmable)
                ((Swimmable) b).swim();

            System.out.println("------------------");
        }
    }

    public void report() {
        int fly = 0, swim = 0, both = 0, none = 0;

        for (Bird b : birds) {
            boolean f = b instanceof Flyable;
            boolean s = b instanceof Swimmable;

            if (f && s) both++;
            else if (f) fly++;
            else if (s) swim++;
            else none++;
        }

        System.out.println("Flyable: " + fly);
        System.out.println("Swimmable: " + swim);
        System.out.println("Both: " + both);
        System.out.println("Neither: " + none);
    }
}
