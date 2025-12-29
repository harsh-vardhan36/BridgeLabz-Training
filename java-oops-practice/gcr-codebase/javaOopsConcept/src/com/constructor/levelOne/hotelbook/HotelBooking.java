package com.constructor.levelOne.hotelbook;

public class HotelBooking {
	String guestName;
	String roomType;
	int nights;
	
	// default constructors
	HotelBooking(){
		guestName = "abc";
		roomType = "non-ac";
		nights = 1;

	}
	// parametrized constructor
	HotelBooking(String g, String r, int n){
		guestName = g;
		roomType = r;
		nights = n;
	}
	// copy- constructor
	HotelBooking( HotelBooking h){
		guestName = h.guestName;
		roomType = h.roomType;
		nights = h.nights;
	}
	void display() {
        System.out.println("guest name is : " + guestName + 
        					"\t room type is :" + roomType +
        					" \t the total night stay is :" + nights);
}
}
