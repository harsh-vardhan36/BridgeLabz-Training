package com.reflections.advance.dependencyreflection;

public class MainApp {

	public static void main(String[] args) {

		Car car = DIContainer.createObject(Car.class);
		car.drive();
	}
}