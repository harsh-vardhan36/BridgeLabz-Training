package com.app.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.greeting.model.User;

@Controller
public class UserController {
@GetMapping("/greetuser")
public String greetUser(@RequestParam String name, @RequestParam String email, Model model) {
	model.addAttribute("name", name);
	model.addAttribute("email", email);
	return "userGreeting";
	
}

@GetMapping("/greet/{name}")
public String greetName(@PathVariable String name,  Model model) {
	model.addAttribute("userName", name);
	return "greetName";
}

@GetMapping("/greeting")
public String greetingForm() {
	return "greetingForm";
}

@PostMapping("/submitGreeting")
public String submitGreeting(@ModelAttribute User  user, Model model) {
	model.addAttribute("name", user.getName());
	model.addAttribute("email",user.getEmail());
	model.addAttribute("age", user.getAge());
	return "userGreeting";
}
}
