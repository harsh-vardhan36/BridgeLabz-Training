package com.app.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.greeting.model.RegistrationUser;
import com.app.greeting.service.RegistrationService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

    private final RegistrationService registrationService;

    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    // Registration
   

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute(
                "user",
                new RegistrationUser()
        );

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid RegistrationUser user,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        boolean registered =
                registrationService.registerUser(user);

        if (!registered) {

            model.addAttribute(
                    "registrationError",
                    "An account with this email already exists."
            );

            model.addAttribute("user", user);

            return "register";
        }

        return "redirect:/login";
    }

    // -------------------------------
    // Login
    // -------------------------------

    @GetMapping("/login")
    public String showLoginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        RegistrationUser user =
                registrationService.loginUser(
                        email,
                        password
                );

        if (user == null) {

            model.addAttribute(
                    "loginError",
                    "Invalid email or password."
            );

            return "login";
        }

        session.setAttribute(
                "loggedInUser",
                user
        );

        return "redirect:/greeting";
    }

    // -------------------------------
    // Greeting
    // -------------------------------

    @GetMapping("/greeting")
    public String greeting(
            HttpSession session,
            Model model) {

        RegistrationUser user =
                (RegistrationUser)
                session.getAttribute("loggedInUser");

        if (user == null) {

            return "redirect:/login";
        }

        model.addAttribute(
                "name",
                user.getName()
        );

        return "greeting";
    }

    // -------------------------------
    // Logout
    // -------------------------------

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }
}