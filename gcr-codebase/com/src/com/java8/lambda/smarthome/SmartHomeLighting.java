package com.java8.lambda.smarthome;

public class SmartHomeLighting {

	public static void main(String [] args) {
		LightAction motiontrigger = () -> 
			System.out.println("Someone Enters...\nGuest Room Lights are Glowing");
		LightAction morning = () -> 
			System.out.println("Good morning....\n Lights are going to be turn off...");
		LightAction voice = () -> 
			System.out.println("Harsh is this you. Got it Let me turn on all the lights..");
		
			motiontrigger.activate();
			morning.activate();
			voice.activate();
	}
}