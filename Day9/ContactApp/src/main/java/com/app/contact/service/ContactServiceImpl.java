package com.app.contact.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.contact.dto.ContactRequest;
import com.app.contact.dto.ContactResponse;
import com.app.contact.entity.Contact;
import com.app.contact.exception.ContactNotFoundException;
import com.app.contact.mapper.ContactMapper;
import com.app.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactServiceImpl(
            ContactRepository contactRepository,
            ContactMapper contactMapper) {

        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    @Override
    public ContactResponse createContact(ContactRequest request) {

        // DTO → Entity
        Contact contact = contactMapper.toEntity(request);

        // Save entity
        Contact savedContact = contactRepository.save(contact);

        // Entity → Response DTO
        return contactMapper.toResponse(savedContact);
    }

    @Override
    public List<ContactResponse> getAllContacts() {

        List<Contact> contacts = contactRepository.findAll();

        return contacts.stream()
                .map(contactMapper::toResponse)
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

        return contactMapper.toResponse(contact);
    }

    @Override
    public ContactResponse updateContact(
            Long id,
            ContactRequest request) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new ContactNotFoundException(
                                "Contact not found with id: " + id
                        )
                );

        // Update existing entity
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contact.setSecondaryPhone(request.getSecondaryPhone());

        // Save updated entity
        Contact updatedContact = contactRepository.save(contact);

        // Entity → Response DTO
        return contactMapper.toResponse(updatedContact);
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