package com.revature.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("code")
public class CodingMotivationService implements MotivationService {
	
	public CodingMotivationService() {
		super();
		System.out.println("CodingMotivationService no-args constructor invoked!");
	}
	
	public String getMotivation() {
		return "Don't quit. Suffer now and code the rest of your life like a boss.";
	}

}
