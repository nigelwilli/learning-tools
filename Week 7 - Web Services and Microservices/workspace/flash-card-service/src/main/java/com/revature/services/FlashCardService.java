package com.revature.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.intercom.AuthClient;

@Service
public class FlashCardService {
	
	private AuthClient authClient;
	
	@Autowired
	public FlashCardService(AuthClient client) {
		this.authClient = client;
	}
	
	@HystrixCommand(fallbackMethod="myFallback")
	public String consumeAuthServiceTest() {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = URI.create("http://localhost:10001/test");
		return restTemplate.getForObject(uri, String.class);
	}
	
	@HystrixCommand(fallbackMethod="myFallback2")
	public String consumeAuthServiceOrangeHex() {
		return authClient.orange();
	}

	public String myFallback() {
		return "The fallback method has been invoked!";
	}
	
	public String myFallback2() {
		return "The fallback method #2 has been invoked!";
	}
	
}
