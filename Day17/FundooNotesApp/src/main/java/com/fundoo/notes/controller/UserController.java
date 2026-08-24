package com.fundoo.notes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.fundoo.notes.dto.UserRegistrationDTO;
import com.fundoo.notes.dto.UserResponseDTO;
import com.fundoo.notes.dto.ForgotPasswordRequest;
import com.fundoo.notes.dto.LoginDTO;
import com.fundoo.notes.dto.LoginResponseDTO;
import com.fundoo.notes.dto.ResetPasswordRequest;
import com.fundoo.notes.service.PasswordResetService;
import com.fundoo.notes.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PasswordResetService passwordResetService;

    UserController(UserService userService,  PasswordResetService passwordResetService) {
        this.userService = userService;
        this.passwordResetService = passwordResetService;
    }

    // Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRegistrationDTO dto) {
        UserResponseDTO response = userService.registerUser(dto);
        return ResponseEntity.ok(response);
    }

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginDTO dto) {
        LoginResponseDTO response = userService.loginUser(dto);
        return ResponseEntity.ok(response);
    }
    // view profile details
    @GetMapping("/me")
    public UserResponseDTO getCurrentUser(Authentication authentication) {
        return userService.getCurrentUser(authentication.getName());
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        String token = passwordResetService.forgotPassword(request.getEmail());
        return ResponseEntity.ok("Reset token: " + token);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        passwordResetService.resetPassword(request.getToken(), request.getNewPassword());
        return ResponseEntity.ok("Password reset successful.");
    }

}
