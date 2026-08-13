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
import com.app.contact.mapper.ContactMapper;
import com.app.contact.repository.ContactRepository;

@ExtendWith(MockitoExtension.class)
class ContactServiceImplTest {

    @Mock
    private ContactRepository contactRepository;

    @Mock
    private ContactMapper contactMapper;

    @InjectMocks
    private ContactServiceImpl contactServiceImpl;


        // CREATE
    

    @Test
    void createContact_shouldCreateContactSuccessfully() {

        // Arrange
        ContactRequest request = new ContactRequest();

        request.setFirstName("Harsh");
        request.setLastName("Vardhan");
        request.setEmail("harsh@gmail.com");
        request.setPhone("9876543210");
        request.setSecondaryPhone("9123456780");

        Contact contact = new Contact(
                "Harsh",
                "Vardhan",
                "harsh@gmail.com",
                "9876543210",
                "9123456780"
        );

        Contact savedContact = contact;

        ContactResponse expectedResponse = new ContactResponse();

        expectedResponse.setFirstName("Harsh");
        expectedResponse.setLastName("Vardhan");
        expectedResponse.setEmail("harsh@gmail.com");
        expectedResponse.setPhone("9876543210");
        expectedResponse.setSecondaryPhone("9123456780");

        when(contactMapper.toEntity(request))
                .thenReturn(contact);

        when(contactRepository.save(any(Contact.class)))
                .thenReturn(savedContact);

        when(contactMapper.toResponse(savedContact))
                .thenReturn(expectedResponse);


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
        verify(contactMapper).toEntity(request);
        verify(contactRepository).save(contact);
        verify(contactMapper).toResponse(savedContact);
    }

    // GET ALL
   

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

        ContactResponse response1 = new ContactResponse();

        response1.setFirstName("Harsh");
        response1.setLastName("Vardhan");
        response1.setEmail("harsh@gmail.com");
        response1.setPhone("9876543210");
        response1.setSecondaryPhone("9123456780");

        ContactResponse response2 = new ContactResponse();

        response2.setFirstName("Rahul");
        response2.setLastName("Kumar");
        response2.setEmail("rahul@gmail.com");
        response2.setPhone("8765432109");

        when(contactRepository.findAll())
                .thenReturn(List.of(contact1, contact2));

        when(contactMapper.toResponse(contact1))
                .thenReturn(response1);

        when(contactMapper.toResponse(contact2))
                .thenReturn(response2);


        // Act
        List<ContactResponse> responses =
                contactServiceImpl.getAllContacts();


        // Assert
        assertEquals(2, responses.size());

        assertEquals("Harsh", responses.get(0).getFirstName());
        assertEquals("Vardhan", responses.get(0).getLastName());
        assertEquals("harsh@gmail.com", responses.get(0).getEmail());

        assertEquals("Rahul", responses.get(1).getFirstName());
        assertEquals("Kumar", responses.get(1).getLastName());
        assertEquals("rahul@gmail.com", responses.get(1).getEmail());


        // Verify
        verify(contactRepository).findAll();
        verify(contactMapper).toResponse(contact1);
        verify(contactMapper).toResponse(contact2);
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

    // GET BY ID
    

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

        ContactResponse expectedResponse = new ContactResponse();

        expectedResponse.setFirstName("Harsh");
        expectedResponse.setLastName("Vardhan");
        expectedResponse.setEmail("harsh@gmail.com");
        expectedResponse.setPhone("9876543210");
        expectedResponse.setSecondaryPhone("9123456780");

        when(contactRepository.findById(contactId))
                .thenReturn(Optional.of(contact));

        when(contactMapper.toResponse(contact))
                .thenReturn(expectedResponse);


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
        verify(contactMapper).toResponse(contact);
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

    // UPDATE

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

        ContactResponse expectedResponse = new ContactResponse();

        expectedResponse.setFirstName("Harsh");
        expectedResponse.setLastName("Vardhan");
        expectedResponse.setEmail("new@gmail.com");
        expectedResponse.setPhone("9123456789");
        expectedResponse.setSecondaryPhone("8765432109");

        when(contactRepository.findById(contactId))
                .thenReturn(Optional.of(existingContact));

        when(contactRepository.save(any(Contact.class)))
                .thenReturn(updatedContact);

        when(contactMapper.toResponse(updatedContact))
                .thenReturn(expectedResponse);


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
        verify(contactMapper).toResponse(updatedContact);
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

    // DELETE

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


        // Assert + Verify
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