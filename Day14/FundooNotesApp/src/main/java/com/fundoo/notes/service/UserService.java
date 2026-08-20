package com.fundoo.notes.service;

import com.fundoo.notes.dto.LoginDTO;
import com.fundoo.notes.dto.LoginResponseDTO;
import com.fundoo.notes.dto.UserRegistrationDTO;
import com.fundoo.notes.dto.UserResponseDTO;

public interface UserService {
	UserResponseDTO registerUser(UserRegistrationDTO dto);
	LoginResponseDTO loginUser(LoginDTO dto);
	UserResponseDTO getCurrentUser(String email);
}
