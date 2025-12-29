package com.constructor.levelOne.circleShape;

public class Circle {

	double radius;
	
	// default constructor for constructor chaining
	Circle() {
		this(1.0);
	}
	//parametrized constructor
	Circle(double radius){
		this.radius = radius;
	}
	
	void display() {
        System.out.println("Radius = " + radius);
    }
	
}
