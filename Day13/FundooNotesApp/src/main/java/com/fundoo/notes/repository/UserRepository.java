package com.fundoo.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoo.notes.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	User findByUserName(String userName);
	
}
