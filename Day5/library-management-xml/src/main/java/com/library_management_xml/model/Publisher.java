package com.library_management_xml.model;

public class Publisher {
		private String name;
		
		public Publisher(String name) {
			this.name = name ;
		}
		
		public void display() {
			System.out.println("Publisher: "+name);
		}
}
