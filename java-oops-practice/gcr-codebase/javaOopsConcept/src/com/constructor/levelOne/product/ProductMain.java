package com.constructor.levelOne.product;

public class ProductMain {
	public static void main(String[] args) {
		//create obj and call class and instance methods 
		  Product p1 = new Product("Laptop", 55000);
	        Product p2 = new Product("Headphone", 1200);
	        Product p3 = new Product("Printer", 25000);
	        
	        p1.displayProductDetails();
	        System.out.println();
	        p2.displayProductDetails();
	        System.out.println();
	        p3.displayProductDetails();
	        System.out.println();
	        
	        Product.displayTotalProducts();
	}
}
