package com.revature.models;

import com.revature.services.MotivationService;

public class TrackCoach implements Coach {

	private MotivationService motivateService;
	
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
