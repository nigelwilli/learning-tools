package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component
public class CodeCoach implements Coach {

	private MotivationService motivateService;
	
	@Autowired
	public CodeCoach(@Qualifier("code") MotivationService service) {
		super();
		this.motivateService = service;
		System.out.println("TrackCoach parameterized constructor invoked!");
	}

	@Override
	public String getDailyWorkout() {
		return "Today's workout: Code.";
	}

	@Override
	public String getMotivation() {
		return "The track coach says: " + motivateService.getMotivation();
	}
	
}
