package com.app.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.greeting.model.RegisterationUser;
import com.app.greeting.service.RegistrationService;

import jakarta.validation.Valid;

@Controller
public class RegisterationController {
	
	private final RegistrationService registerationService;
	public RegisterationController(RegistrationService registrationService) {
	    this.registerationService = registrationService;
	}
	
@GetMapping("/register")
public String registerUser(Model model) {
	model.addAttribute("user", new RegisterationUser());
	return "register";
}
@PostMapping("/register")
public String registerationUserDetails(@Valid @ModelAttribute("user") RegisterationUser user, BindingResult result, Model model) {
	if(result.hasErrors()) {
		return "register";
	}
	boolean registered = registerationService.addUser(user);
	if(!registered) {
		return "register";
	}
	model.addAttribute("user",user);
	return  "registerGreeting";
	
}
}
