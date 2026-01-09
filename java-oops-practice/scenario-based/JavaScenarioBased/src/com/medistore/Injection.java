package com.medistore;
import java.time.LocalDate;
class Injection extends Medicine {
Injection(String name, double price, LocalDate expiryDate, int quantity){
	super(name, price, expiryDate, quantity);
	

}
@Override
public boolean checkExpiry() {
	return expiryDate.minusDays(5).isBefore(LocalDate.now());
}
}
