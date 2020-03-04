package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;
import com.revature.services.SportMotivationService;

@Scope("prototype")
@Component("myCoach")
public class BaseballCoach implements Coach {
	
	private MotivationService motivateService;
	
	public BaseballCoach()  {
		super();
		System.out.println("BaseballCoach no-args constructor invoked!");
	}
	
	@Autowired
	public BaseballCoach(SportMotivationService service) {
		super();
		this.motivateService = service;
		System.out.println("BaseballCoach parameterized constructor invoked!");
	}

	@Override
	public String getDailyWorkout() {
		return "Today's workout: Spend 30 minutes on batting practice";
	}

	@Override
	public String getMotivation() {
		return "The baseball coach says: " + motivateService.getMotivation();
	}

}
