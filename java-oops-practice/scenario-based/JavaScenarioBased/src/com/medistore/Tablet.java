package com.medistore;
import java.time.LocalDate;
 class Tablet extends Medicine{
	
	
 Tablet(String name, double price, LocalDate expiryDate, int quantity){
	 super(name, price, expiryDate, quantity);
	 
	 
 }
 @Override
 public boolean checkExpiry() {
	 return expiryDate.plusDays(60).isBefore(LocalDate.now());
 }
 
}
