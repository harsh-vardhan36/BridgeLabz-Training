package com.constructor.levelOne;
import java.util.Scanner;
public class BookMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Book myBook = new Book("The wise tales","Harsh-Vardhan", 249);
		String Author, Title;
		double cost;
		System.out.println("Enter the Book Title: ");
		Title = input.nextLine();
		System.out.println("Enter the Book Title: ");
		Author = input.nextLine();
		System.out.println("Enter the Price: ");
		cost = input.nextDouble();
		myBook.DisplayBook();
		Book myNextBook = new Book(Title, Author, cost);
		myNextBook.DisplayBook();
	}
}

