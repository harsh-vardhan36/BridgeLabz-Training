package com.app.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

	@GetMapping("/greet")
	public String greet() {
		return "greeting";
	}
	@GetMapping("/off")
	public String bye() {
		return "bye";
	}
}
