package com.addressbook;

import java.util.ArrayList;

class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    // Add Contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Display All Contacts
    public void showAllContacts() {
        for (Contact c : contacts) {
            c.displayContact();
        }
    }
}

