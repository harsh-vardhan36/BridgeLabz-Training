package com.app.contact.service;

import java.util.List;

import com.app.contact.dto.ContactRequest;
import com.app.contact.dto.ContactResponse;

public interface ContactService {

    ContactResponse createContact(ContactRequest request);

    List<ContactResponse> getAllContacts();

    ContactResponse getContactById(Long id);

    ContactResponse updateContact(Long id, ContactRequest request);

    void deleteContact(Long id);
}