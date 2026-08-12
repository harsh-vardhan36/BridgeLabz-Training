package com.app.contact.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.contact.dto.ContactRequest;
import com.app.contact.dto.ContactResponse;
import com.app.contact.entity.Contact;
import com.app.contact.exception.ContactNotFoundException;
import com.app.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

	@Override
	public ContactResponse createContact(ContactRequest request) {

	  
		Contact contact = new Contact(request.getFirstName(), request.getLastName(), request.getEmail()
				, request.getPhone(), request.getSecondaryPhone());

	    
		Contact savedContact = contactRepository.save(contact);
		
		ContactResponse contactResponse = new ContactResponse();
	   
		contactResponse.setId(savedContact.getId());
		contactResponse.setFirstName(savedContact.getFirstName());
		contactResponse.setLastName(savedContact.getLastName());
		contactResponse.setEmail(savedContact.getEmail());
		contactResponse.setPhone(savedContact.getPhone());
		contactResponse.setSecondaryPhone(savedContact.getSecondaryPhone());
		
		return contactResponse;
	}

	@Override
	public List<ContactResponse> getAllContacts() {

	    List<Contact> contacts = contactRepository.findAll();

	    return contacts.stream()
	            .map(contact -> {
	                ContactResponse response = new ContactResponse();

	                response.setId(contact.getId());
	                response.setFirstName(contact.getFirstName());
	                response.setLastName(contact.getLastName());
	                response.setEmail(contact.getEmail());
	                response.setPhone(contact.getPhone());
	                response.setSecondaryPhone(contact.getSecondaryPhone());

	                return response;
	            })
	            .toList();
	}

	@Override
	public ContactResponse getContactById(Long id) {

	    Contact contact = contactRepository.findById(id)
	            .orElseThrow(() ->
	                new ContactNotFoundException(
	                    "Contact not found with id: " + id
	                )
	            );

	    ContactResponse response = new ContactResponse();

	    response.setId(contact.getId());
	    response.setFirstName(contact.getFirstName());
	    response.setLastName(contact.getLastName());
	    response.setEmail(contact.getEmail());
	    response.setPhone(contact.getPhone());
	    response.setSecondaryPhone(contact.getSecondaryPhone());

	    return response;
	}

	@Override
	public ContactResponse updateContact(Long id, ContactRequest request) {

	    Contact contact = contactRepository.findById(id)
	            .orElseThrow(() ->
	                new ContactNotFoundException(
	                    "Contact not found with id: " + id
	                )
	            );

	    contact.setFirstName(request.getFirstName());
	    contact.setLastName(request.getLastName());
	    contact.setEmail(request.getEmail());
	    contact.setPhone(request.getPhone());
	    contact.setSecondaryPhone(request.getSecondaryPhone());

	    Contact updatedContact = contactRepository.save(contact);

	    ContactResponse response = new ContactResponse();

	    response.setId(updatedContact.getId());
	    response.setFirstName(updatedContact.getFirstName());
	    response.setLastName(updatedContact.getLastName());
	    response.setEmail(updatedContact.getEmail());
	    response.setPhone(updatedContact.getPhone());
	    response.setSecondaryPhone(updatedContact.getSecondaryPhone());

	    return response;
	}

	@Override
	public void deleteContact(Long id) {

	    contactRepository.findById(id)
	            .orElseThrow(() ->
	                new ContactNotFoundException(
	                    "Contact not found with id: " + id
	                )
	            );

	    contactRepository.deleteById(id);
	}

}