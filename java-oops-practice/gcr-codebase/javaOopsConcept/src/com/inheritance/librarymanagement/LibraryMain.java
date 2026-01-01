package com.inheritance.librarymanagement;

public class LibraryMain {
	public static void main(String[] args) {
		
		Book b = new Book("ABC", 2004);
		Author ar = new Author("Priyanshu",2026,"PQR","DONE");
		b.displayinfo();
		ar.displayinfo();
	}
}
