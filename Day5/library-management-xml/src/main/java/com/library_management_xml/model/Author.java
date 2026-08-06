package com.library_management_xml.model;

public class Author {
	private String name;
	public  Author(String name){
		this.name = name;
		System.out.println("Author Constructor Executed");
	}
	
	public void display() {
		System.out.println("Author: "+ name);
	}
}
