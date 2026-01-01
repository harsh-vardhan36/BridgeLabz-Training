package com.inheritance.animalhierarchy;

class Animal{
	String name;
	int age;
	
	void makeSound() {
		System.out.println("Animals make sound");
	}
}

class Dog extends Animal{
	void makeSound() {
		System.out.println("Dog make sound");
	}
}

class Cat extends Animal{
	void makeSound() {
		System.out.println("Cat make sound");
	}
}

class Bird extends Animal{
	void makeSound() {
		System.out.println("Bird make sound");
	}
}

public class AnimalHierarchy {

	public static void main(String[] args) {
		
		Bird bird = new Bird();
		Cat cat = new Cat();
		Dog dog = new Dog();
		Animal animal = new Animal();
		
		bird.makeSound();
		cat.makeSound();
		dog.makeSound();
		animal.makeSound();

	}

}