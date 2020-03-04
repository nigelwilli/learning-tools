package com.revature.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping(produces="text/plain")
	public String test() {
		return "Hello, Spring Cloud Microservices!";
	}
	
	@GetMapping(value="/orangeHex", produces="text/plain")
	public String orange() {
		return "ffa500";
	}

}
