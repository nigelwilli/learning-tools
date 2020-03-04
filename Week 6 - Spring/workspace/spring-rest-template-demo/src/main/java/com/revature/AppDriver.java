package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.revature.models.FlashCard;

public class AppDriver {
	
	private static final Logger log = LoggerFactory.getLogger(AppDriver.class);
	private static final String API_URL = "http://localhost:5000/flash-cards";
	
	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			
			log.info("Getting all flash cards...");
			ResponseEntity<FlashCard[]> allCards = restTemplate.getForEntity(API_URL, FlashCard[].class);
			log.info("Resource consumption successful");
			log.info(allCards.toString());
			log.info("Status code: [" + allCards.getStatusCodeValue() + "] - " + allCards.getStatusCode());
			log.info("Response headers: " + allCards.getHeaders());
			log.info("Payload: ");
			for(FlashCard card : allCards.getBody()) {
				log.info("\t" + card);
			}
			
			//------------------------------------------------------------------------------------------------
			
			log.info("Getting flash card by id...");
			ResponseEntity<FlashCard> cardResponse = restTemplate.getForEntity(API_URL + "/3", FlashCard.class);
			log.info(cardResponse.getBody().toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Resource consumption unsuccessful");
		}
	}

}
