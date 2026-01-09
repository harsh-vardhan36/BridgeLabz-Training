package com.medistore;
import java.time.LocalDate;
class Syrup extends Medicine{
Syrup(String name, double price, LocalDate expiryDate, int quantity){
	super(name, price, expiryDate, quantity);
}

public boolean checkExpiry() {
 return expiryDate.isBefore(LocalDate.now());
}
}
