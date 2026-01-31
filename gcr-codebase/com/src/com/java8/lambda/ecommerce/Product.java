package com.java8.lambda.ecommerce;

public class Product {
	
	 private String name;
	 private double price;
	 private double rating;
	 private double discount;
	 
	 public Product(String name, double price, double rating, double discount) {
		 this.name = name;
	        this.price = price;
	        this.rating = rating;
	        this.discount = discount;
	 }
	 public double getPrice() {
		 return price;
	 }
	 public double getRating() {
		 return rating;
	 }
	 public double getDiscount() {
		 return discount;
	 }
	 public String getName() {
		 return name;
	 }
}
