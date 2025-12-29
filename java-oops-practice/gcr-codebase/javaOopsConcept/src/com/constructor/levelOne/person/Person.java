package com.constructor.levelOne.person;

public class Person {
	 String name;
	    int age;

	    // Parameterized constructor
	    Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    // Copy constructor
	    Person(Person p) {
	        name = p.name;
	        age = p.age;
	    }

	    void display() {
	        System.out.println("Name: " + name);
	        System.out.println("Age : " + age);
	    }
}
