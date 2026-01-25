package com.regex;
import java.util.*;
public class emailvalidator {

	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		boolean isTrue = true;
		String username;
		String regex = "^[a-zA-Z][a-zA-Z0-9@a-z.a-z]{4,14}$";
		char val;
		while(isTrue) {
		System.out.println("Enter the username: ");
		username = in.nextLine();
		
		
		if(username.matches(regex)) {
			System.out.println("Verified!");
		}
		else {
			System.out.println("Not Verified!");
		}
		System.out.println("Do you want to check the Username again: y or n ");
		val = in.next().charAt(0);
		if( val == 'y') {
			isTrue = true;
		}
		isTrue = false;
		}
	}
}
