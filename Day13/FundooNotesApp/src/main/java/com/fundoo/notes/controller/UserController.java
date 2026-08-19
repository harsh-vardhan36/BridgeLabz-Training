package com.fundoo.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fundoo.notes.dto.UserRegistrationDTO;
import com.fundoo.notes.dto.UserResponseDTO;
import com.fundoo.notes.dto.LoginDTO;
import com.fundoo.notes.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRegistrationDTO dto) {
        UserResponseDTO response = userService.registerUser(dto);
        return ResponseEntity.ok(response);
    }

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser(@Valid @RequestBody LoginDTO dto) {
        UserResponseDTO response = userService.loginUser(dto);
        return ResponseEntity.ok(response);
    }
}
