//program  to create a substring from a String using the charAt() method.
import java.util.*;
public class SubString{
	//Creating a Method to find Substring.
	public static String findSubString(String text, int start, int end){
		String sub_string ="";
		for(int i = start; i<=end; i++) sub_string += text.charAt(i);
		
	 return sub_string;
	}
	
	//Creating a Method to use BuiltIn function to find Substring.
	public static String subStringusingBuiltIn(String text, int start, int end){
	 String suBstring = text.substring(start,end+1);
	 return suBstring;
	}
	
	//Creating a Boolean Method to compare the Both Substring.
	public static boolean isStringSame(String result, String UsingResult){
	 boolean isSame = true;
	 if(result.length()!= UsingResult.length()) {
		 isSame = false;
		 return isSame;
	 }

	for(int i = 0; i <result.length(); i++){
	  if(result.charAt(i)!= UsingResult.charAt(i)) isSame = false; 
	  
    }
	
	 return isSame;
	}
	
	//Calling the main method.
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	
	//Taking Values from user.
	System.out.print("Enter the string: ");
	String text = in.next();
	System.out.print("Enter the Start Index: ");
	int start = in.nextInt();
	System.out.print("Enter the End Index: ");
	int end = in.nextInt();
	
	//calling the Both methods.
	String result = findSubString(text,start,end);
	System.out.println("Substring using charAt: "+ result);
	String UsingResult = subStringusingBuiltIn(text,start,end);
	System.out.println("Substring using BuiltIn Function: "+ UsingResult);
	
	//Comparing the both Substring.
	System.out.println("Is Both Substring Same: "+ isStringSame(result, UsingResult));
	}
}