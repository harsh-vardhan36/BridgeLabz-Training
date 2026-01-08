package com.linearandbinarysearch.stringbuilder;

public class ReverseString {

	public static void main(String[] args) {
		
		// declaring sb object
		StringBuilder sb = new StringBuilder("Harsh");
		
		// reversing
		sb.reverse();
		
		// to string
		String ans = sb.toString();
		
		System.out.println(ans);
	}

}