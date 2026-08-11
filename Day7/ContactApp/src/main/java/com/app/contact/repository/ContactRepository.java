package com.app.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.contact.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
