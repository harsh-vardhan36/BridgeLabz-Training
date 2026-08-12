package com.app.contact.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.contact.dto.ContactRequest;
import com.app.contact.dto.ContactResponse;
import com.app.contact.entity.Contact;
import com.app.contact.exception.ContactNotFoundException;
import com.app.contact.repository.ContactRepository;

@ExtendWith(MockitoExtension.class)
class ContactServiceImplTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactServiceImpl;


    
    // checking CREATE method 
 

    @Test
    void createContact_shouldCreateContactSuccessfully() {

        // Arrange
        ContactRequest request = new ContactRequest();

        request.setFirstName("Harsh");
        request.setLastName("Vardhan");
        request.setEmail("harsh@gmail.com");
        request.setPhone("9876543210");
        request.setSecondaryPhone("9123456780");

        Contact savedContact = new Contact(
                "Harsh",
                "Vardhan",
                "harsh@gmail.com",
                "9876543210",
                "9123456780"
        );

        when(contactRepository.save(any(Contact.class)))
                .thenReturn(savedContact);

        // Act
        ContactResponse response =
                contactServiceImpl.createContact(request);

        // Assert
        assertEquals("Harsh", response.getFirstName());
        assertEquals("Vardhan", response.getLastName());
        assertEquals("harsh@gmail.com", response.getEmail());
        assertEquals("9876543210", response.getPhone());
        assertEquals("9123456780", response.getSecondaryPhone());

        // Verify
        verify(contactRepository).save(any(Contact.class));
    }


    
    // checking GET ALL method
   

    @Test
    void getAllContacts_shouldReturnAllContacts() {

        // Arrange
        Contact contact1 = new Contact(
                "Harsh",
                "Vardhan",
                "harsh@gmail.com",
                "9876543210",
                "9123456780"
        );

        Contact contact2 = new Contact(
                "Rahul",
                "Kumar",
                "rahul@gmail.com",
                "8765432109",
                null
        );

        when(contactRepository.findAll())
                .thenReturn(List.of(contact1, contact2));

        // Act
        List<ContactResponse> responses =
                contactServiceImpl.getAllContacts();

        // Assert
        assertEquals(2, responses.size());

        assertEquals("Harsh", responses.get(0).getFirstName());
        assertEquals("Vardhan", responses.get(0).getLastName());

        assertEquals("Rahul", responses.get(1).getFirstName());
        assertEquals("Kumar", responses.get(1).getLastName());

        // Verify
        verify(contactRepository).findAll();
    }


    @Test
    void getAllContacts_shouldReturnEmptyList_whenNoContactsExist() {

        // Arrange
        when(contactRepository.findAll())
                .thenReturn(List.of());

        // Act
        List<ContactResponse> responses =
                contactServiceImpl.getAllContacts();

        // Assert
        assertEquals(0, responses.size());

        // Verify
        verify(contactRepository).findAll();
    }


   
    // testing GET BY ID method
   

    @Test
    void getContactById_shouldReturnContact_whenContactExists() {

        // Arrange
        Long contactId = 1L;

        Contact contact = new Contact(
                "Harsh",
                "Vardhan",
                "harsh@gmail.com",
                "9876543210",
                "9123456780"
        );

        when(contactRepository.findById(contactId))
                .thenReturn(Optional.of(contact));

        // Act
        ContactResponse response =
                contactServiceImpl.getContactById(contactId);

        // Assert
        assertEquals("Harsh", response.getFirstName());
        assertEquals("Vardhan", response.getLastName());
        assertEquals("harsh@gmail.com", response.getEmail());
        assertEquals("9876543210", response.getPhone());
        assertEquals("9123456780", response.getSecondaryPhone());

        // Verify
        verify(contactRepository).findById(contactId);
    }


    @Test
    void getContactById_shouldThrowException_whenContactDoesNotExist() {

        // Arrange
        Long contactId = 999L;

        when(contactRepository.findById(contactId))
                .thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(
                ContactNotFoundException.class,
                () -> contactServiceImpl.getContactById(contactId)
        );

        // Verify
        verify(contactRepository).findById(contactId);
    }


       // testing UPDATE method
  

    @Test
    void updateContact_shouldUpdateContactSuccessfully() {

        // Arrange
        Long contactId = 1L;

        Contact existingContact = new Contact(
                "Harsh",
                "Vardhan",
                "old@gmail.com",
                "9876543210",
                null
        );

        ContactRequest request = new ContactRequest();

        request.setFirstName("Harsh");
        request.setLastName("Vardhan");
        request.setEmail("new@gmail.com");
        request.setPhone("9123456789");
        request.setSecondaryPhone("8765432109");

        Contact updatedContact = new Contact(
                "Harsh",
                "Vardhan",
                "new@gmail.com",
                "9123456789",
                "8765432109"
        );

        when(contactRepository.findById(contactId))
                .thenReturn(Optional.of(existingContact));

        when(contactRepository.save(any(Contact.class)))
                .thenReturn(updatedContact);

        // Act
        ContactResponse response =
                contactServiceImpl.updateContact(contactId, request);

        // Assert
        assertEquals("Harsh", response.getFirstName());
        assertEquals("Vardhan", response.getLastName());
        assertEquals("new@gmail.com", response.getEmail());
        assertEquals("9123456789", response.getPhone());
        assertEquals("8765432109", response.getSecondaryPhone());

        // Verify
        verify(contactRepository).findById(contactId);
        verify(contactRepository).save(existingContact);
    }


    @Test
    void updateContact_shouldThrowException_whenContactDoesNotExist() {

        // Arrange
        Long contactId = 999L;

        ContactRequest request = new ContactRequest();

        request.setFirstName("Harsh");
        request.setEmail("harsh@gmail.com");
        request.setPhone("9876543210");

        when(contactRepository.findById(contactId))
                .thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(
                ContactNotFoundException.class,
                () -> contactServiceImpl.updateContact(contactId, request)
        );

        // Verify
        verify(contactRepository).findById(contactId);
    }


    
    // checking DELETE method
   

    @Test
    void deleteContact_shouldDeleteContact_whenContactExists() {

        // Arrange
        Long contactId = 1L;

        Contact contact = new Contact(
                "Harsh",
                "Vardhan",
                "harsh@gmail.com",
                "9876543210",
                null
        );

        when(contactRepository.findById(contactId))
                .thenReturn(Optional.of(contact));

        // Act
        contactServiceImpl.deleteContact(contactId);

        // Assert / Verify
        verify(contactRepository).findById(contactId);
        verify(contactRepository).deleteById(contactId);
    }


    @Test
    void deleteContact_shouldThrowException_whenContactDoesNotExist() {

        // Arrange
        Long contactId = 999L;

        when(contactRepository.findById(contactId))
                .thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(
                ContactNotFoundException.class,
                () -> contactServiceImpl.deleteContact(contactId)
        );

        // Verify
        verify(contactRepository).findById(contactId);
    }
}