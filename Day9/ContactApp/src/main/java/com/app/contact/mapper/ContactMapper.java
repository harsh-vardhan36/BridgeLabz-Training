package com.app.contact.mapper;

import org.springframework.stereotype.Component;

import com.app.contact.dto.ContactRequest;
import com.app.contact.dto.ContactResponse;
import com.app.contact.entity.Contact;

@Component
public class ContactMapper {
	public Contact toEntity(ContactRequest request) {
	    return new Contact(
	        request.getFirstName(),
	        request.getLastName(),
	        request.getEmail(),
	        request.getPhone(),
	        request.getSecondaryPhone()
	    );
	}
	public ContactResponse toResponse(Contact contact) {

	    ContactResponse response = new ContactResponse();

	    response.setId(contact.getId());
	    response.setFirstName(contact.getFirstName());
	    response.setLastName(contact.getLastName());
	    response.setEmail(contact.getEmail());
	    response.setPhone(contact.getPhone());
	    response.setSecondaryPhone(contact.getSecondaryPhone());

	    return response;
	}
}
