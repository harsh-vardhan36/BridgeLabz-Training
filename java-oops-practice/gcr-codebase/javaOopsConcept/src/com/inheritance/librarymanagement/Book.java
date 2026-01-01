package com.inheritance.librarymanagement;

public class Book {
	String title;
	int publicationyear;
	Book(String title, int publicationyear){
		this.title = title;
		this.publicationyear = publicationyear;
	}
	void displayinfo() {
		System.out.println("title : " + title + " year : " + publicationyear);
	}
}