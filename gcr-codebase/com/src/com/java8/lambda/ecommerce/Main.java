package com.java8.lambda.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


public class Main {
	public static void main(String [] args) {
		List<Product> products = new ArrayList<>();
		
		products.add(new Product("Laptop", 50000,4.5,10));
		products.add(new Product("Phone",19999,4.2,15));
		products.add(new Product("Headphones",2000,4.8,5));
	
		Comparator<Product>sortByPrice = (p1,p2) -> Double.compare(p1.getPrice(), p2.getPrice());
		   products.sort(sortByPrice);

		  for(Product p : products) {
			 System.out.println(
		    p.getName() + " | " +
		    p.getPrice() + " | " +
		    p.getRating() + " | " +
		    p.getDiscount());
		 }
	}

}
