package com.linearandbinarysearch.stringbuffer;

public class Concatenate {
public static void main(String args[]) {
		
		String[] arr = {"Harsh " + "is " + "a " + "Thinker"};
		
		StringBuffer sb = new StringBuffer();
		
		for(String s : arr) {
			sb.append(s);
		}
		
		System.out.println(sb.toString());
}
}
