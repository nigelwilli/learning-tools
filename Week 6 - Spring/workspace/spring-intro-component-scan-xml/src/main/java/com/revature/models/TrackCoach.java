package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component
public class TrackCoach implements Coach {

	private MotivationService motivateService;
	
	@Autowired
	public TrackCoach(MotivationService service) {
		super();
		this.motivateService = service;
		System.out.println("TrackCoach parameterized constructor invoked!");
	}

	@Override
	public String getDailyWorkout() {
		return "Today's workout: Run a 30-minute 5k";
	}

	@Override
	public String getMotivation() {
		return "The track coach says: " + motivateService.getMotivation();
	}
	
}
