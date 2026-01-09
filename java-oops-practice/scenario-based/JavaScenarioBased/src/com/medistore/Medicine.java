package com.medistore;
import java.time.LocalDate;
public class Medicine implements ISellable {
 String name;
 LocalDate expiryDate;
 private double price;
 private int quantity;
 Medicine(String name, double price, LocalDate expiryDate){
	 this(name,price, expiryDate,10);
 }
 Medicine(String name, double price, LocalDate expiryDate, int quantity ){
	 this.name = name;
	 this.price = price;
	 this.expiryDate = expiryDate;
	 this.quantity = quantity;
 }
 public boolean checkExpiry() {
	 if(expiryDate.isBefore(LocalDate.now())) return true;
	 else return false;
 }
 public void sell(int qty) {
	 double total;
	 if(!checkExpiry()) {
		 if (qty<=quantity) {
			 quantity-=qty;
			 total = price * qty;
			 System.out.println("Your Total amount is: "+ total);
			 if(total>500) {
				 total*=0.9;
				 System.out.println("The amount you need to pay is: "+ total);
			 }
		 }
		 else System.err.println("No Stock available");
	 }
	 else System.err.println("Medicine Expired");
 }
}
