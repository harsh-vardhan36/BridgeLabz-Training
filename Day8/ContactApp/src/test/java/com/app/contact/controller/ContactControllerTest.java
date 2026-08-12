package com.app.contact.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.app.contact.dto.ContactRequest;
import com.app.contact.dto.ContactResponse;
import com.app.contact.service.ContactService;

@WebMvcTest(ContactController.class)
class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ContactService contactService;
    
    // checking  CREATE
 
    @Test
    void createContact_shouldReturn201_whenRequestIsValid() throws Exception {

        // Arrange
        ContactResponse response = new ContactResponse();

        response.setFirstName("Harsh");
        response.setLastName("Vardhan");
        response.setEmail("harsh@gmail.com");
        response.setPhone("9876543210");
        response.setSecondaryPhone("9123456780");

        when(contactService.createContact(any(ContactRequest.class)))
                .thenReturn(response);

        // Act + Assert
        mockMvc.perform(
                post("/api/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "firstName": "Harsh",
                                "lastName": "Vardhan",
                                "email": "harsh@gmail.com",
                                "phone": "9876543210",
                                "secondaryPhone": "9123456780"
                            }
                        """)
        )
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.firstName").value("Harsh"))
        .andExpect(jsonPath("$.lastName").value("Vardhan"))
        .andExpect(jsonPath("$.email").value("harsh@gmail.com"))
        .andExpect(jsonPath("$.phone").value("9876543210"))
        .andExpect(jsonPath("$.secondaryPhone").value("9123456780"));

        verify(contactService).createContact(any(ContactRequest.class));
    }


    @Test
    void createContact_shouldReturn400_whenRequestIsInvalid() throws Exception {

        mockMvc.perform(
                post("/api/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "firstName": "",
                                "email": "invalid-email",
                                "phone": "123"
                            }
                        """)
        )
        .andExpect(status().isBadRequest());
    }

    // checking GET ALL

    @Test
    void getAllContacts_shouldReturn200() throws Exception {

        // Arrange
        ContactResponse contact1 = new ContactResponse();

        contact1.setFirstName("Harsh");
        contact1.setLastName("Vardhan");
        contact1.setEmail("harsh@gmail.com");
        contact1.setPhone("9876543210");

        ContactResponse contact2 = new ContactResponse();

        contact2.setFirstName("Rahul");
        contact2.setLastName("Kumar");
        contact2.setEmail("rahul@gmail.com");
        contact2.setPhone("8765432109");

        when(contactService.getAllContacts())
                .thenReturn(List.of(contact1, contact2));

        // Act + Assert
        mockMvc.perform(
                get("/api/contacts")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].firstName").value("Harsh"))
        .andExpect(jsonPath("$[1].firstName").value("Rahul"));

        verify(contactService).getAllContacts();
    }

    // checking GET BY ID
   

    @Test
    void getContactById_shouldReturn200_whenContactExists() throws Exception {

        // Arrange
        Long contactId = 1L;

        ContactResponse response = new ContactResponse();

        response.setFirstName("Harsh");
        response.setLastName("Vardhan");
        response.setEmail("harsh@gmail.com");
        response.setPhone("9876543210");

        when(contactService.getContactById(contactId))
                .thenReturn(response);

        // Act + Assert
        mockMvc.perform(
                get("/api/contacts/{id}", contactId)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.firstName").value("Harsh"))
        .andExpect(jsonPath("$.email").value("harsh@gmail.com"));

        verify(contactService).getContactById(contactId);
    }

    // checking  UPDATE
    
    @Test
    void updateContact_shouldReturn200_whenRequestIsValid() throws Exception {

        // Arrange
        Long contactId = 1L;

        ContactResponse response = new ContactResponse();

        response.setFirstName("Harsh");
        response.setLastName("Vardhan");
        response.setEmail("newharsh@gmail.com");
        response.setPhone("9876543210");

        when(contactService.updateContact(
                eq(contactId),
                any(ContactRequest.class)
        )).thenReturn(response);

        // Act + Assert
        mockMvc.perform(
                put("/api/contacts/{id}", contactId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "firstName": "Harsh",
                                "lastName": "Vardhan",
                                "email": "newharsh@gmail.com",
                                "phone": "9876543210"
                            }
                        """)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.firstName").value("Harsh"))
        .andExpect(jsonPath("$.email").value("newharsh@gmail.com"));

        verify(contactService).updateContact(
                eq(contactId),
                any(ContactRequest.class)
        );
    }


    @Test
    void updateContact_shouldReturn400_whenRequestIsInvalid() throws Exception {

        mockMvc.perform(
                put("/api/contacts/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "firstName": "",
                                "email": "wrong-email",
                                "phone": "123"
                            }
                        """)
        )
        .andExpect(status().isBadRequest());
    }


    
    // testing DELETE
 

    @Test
    void deleteContact_shouldReturn204_whenContactIsDeleted()
            throws Exception {

        // Arrange
        Long contactId = 1L;

        // void method → Mockito does not need a return value

        // Act + Assert
        mockMvc.perform(
                delete("/api/contacts/{id}", contactId)
        )
        .andExpect(status().isNoContent());

        verify(contactService).deleteContact(contactId);
    }
}