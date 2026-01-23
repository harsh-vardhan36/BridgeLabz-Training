package com.addressbook;

public class Main {
    public static void main(String[] args) {

        AddressBook book = new AddressBook();

        String firstName, lastName,phoneNumber, email, city;
        String state, zip;
        firstName = "Harsh";
        lastName = "Vardhan";
        phoneNumber = "9876543210";
        email = "harsh@email.com";
        city = "Bhopal"; 
        state = "Madhya Pradesh";
        zip = "462021";
        
        Contact c1 = new Contact( firstName,
                 lastName, phoneNumber,
                 email, city, state, zip );

        Contact c2 = new Contact(
                "Amit", "Sharma",
                "9123456780",
                "amit@email.com",
                "Mumbai", "MH", "400001"
        );

        book.addContact(c1);
        book.addContact(c2);

        book.showAllContacts();
    }
}
