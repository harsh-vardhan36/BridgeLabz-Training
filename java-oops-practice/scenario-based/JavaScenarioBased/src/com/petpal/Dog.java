package com.petpal;

class Dog extends Pet {
    public Dog(String name) { super(name, "Dog"); }

    public void feed() { decreaseHunger(30); increaseMood(10); }
    public void play() { decreaseEnergy(20); increaseMood(20); }
    public void sleep() { increaseEnergy(40); }
    void makeSound() { System.out.println("Woof Woof!"); }
}

class Cat extends Pet {
    public Cat(String name) { super(name, "Cat"); }

    public void feed() { decreaseHunger(25); increaseMood(5); }
    public void play() { decreaseEnergy(15); increaseMood(15); }
    public void sleep() { increaseEnergy(50); }
    void makeSound() { System.out.println("Meow!"); }
}

class Bird extends Pet {
    public Bird(String name) { super(name, "Bird"); }

    public void feed() { decreaseHunger(20); increaseMood(10); }
    public void play() { decreaseEnergy(10); increaseMood(15); }
    public void sleep() { increaseEnergy(30); }
    void makeSound() { System.out.println("Chirp Chirp!"); }
}

