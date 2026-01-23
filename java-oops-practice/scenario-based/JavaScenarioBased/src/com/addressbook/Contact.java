package com.addressbook;

class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String city;
    private String state;
    private String zip;

    // Constructor
    public Contact(String firstName, String lastName,
                   String phoneNumber, String email,
                   String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getter
    public String getFirstName() {
        return firstName;
    }

    // Display Contact
    public void displayContact() {
        System.out.println(firstName + " " + lastName +
                " | Phone: " + phoneNumber +
                " | Email: " + email +
                " | Address: " + city + ", " + state + " - " + zip);
    }
}
