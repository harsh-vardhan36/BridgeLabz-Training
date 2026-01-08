package com.linearandbinarysearch.stringbuilder;
import java.util.HashSet;
public class RemoveDuplicates {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		HashSet<Character> hn = new HashSet<>();
		
		String str = "HarshVardhan";
		
		for(char ch : str.toCharArray()) {
			if(hn.contains(ch) != true) {
				sb.append(ch);
				hn.add(ch);
			}
		}
		
		System.out.println(sb.toString());
	}



}
