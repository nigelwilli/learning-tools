package com.revature.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-controller")
public class TestController {
	
	@GetMapping(value="/test", produces="text/plain")
	public String test() {
		return "Hello, Spring Boot!";
	}

}
