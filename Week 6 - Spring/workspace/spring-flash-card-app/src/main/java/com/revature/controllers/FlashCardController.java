package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.FlashCard;
import com.revature.services.FlashCardService;

@RestController
@RequestMapping("/flash-cards")
public class FlashCardController {

	private FlashCardService cardService;
	
	@Autowired
	public FlashCardController(FlashCardService service) {
		this.cardService = service;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAllCards() {
		return cardService.getAll();
	}
}
