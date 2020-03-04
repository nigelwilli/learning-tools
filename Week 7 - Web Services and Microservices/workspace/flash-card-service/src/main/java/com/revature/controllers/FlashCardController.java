package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.FlashCardService;

@RestController
@RequestMapping("/flash-cards")
public class FlashCardController {
	
	private FlashCardService cardService;
	
	@Autowired
	public FlashCardController(FlashCardService service) {
		this.cardService = service;
	}
	
	@GetMapping(produces = "text/plain")
	public String test() {
		return "flash-card-service works!";
	}
	
	@GetMapping(value="/intercom", produces = "text/plain")
	public String intercom() {
		return cardService.consumeAuthServiceTest();
	}
	
	@GetMapping(value="/intercom2", produces = "text/plain")
	public String intercom2() {
		return cardService.consumeAuthServiceOrangeHex();
	}

}
