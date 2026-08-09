package com.app.greeting.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.greeting.model.RegisterationUser;
import com.app.greeting.service.RegistrationService;

@Controller
public class LoginController {

    private final RegistrationService registrationService;

    public LoginController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    
    public String loginNow() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSuccess(String email, String password) {

        RegisterationUser register = new RegisterationUser();

        register.setEmail(email);
        register.setPassword(password);

        boolean loggedIn = registrationService.findUser(register);

        if (loggedIn) {
            return "loginSuccess";
        }

        return "login";
    }
}