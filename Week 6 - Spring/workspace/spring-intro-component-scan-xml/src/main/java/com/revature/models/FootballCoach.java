package com.revature.models;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component
public class FootballCoach implements Coach {
	
	@Value("${coach.email}")
	private String email;
	
	@Value("The Baddy Pitbulls")
	private String team;

	private MotivationService motivateService;
	
	public FootballCoach() {
		super();
		System.out.println("FootballCoach no-args constructor invoked!");
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public MotivationService getMotivateService() {
		return motivateService;
	}

	@Autowired
	public void setMotivateService(MotivationService motivateService) {
		this.motivateService = motivateService;
	}
	
	@PostConstruct
	public void customInit() {
		System.out.println("FootballCoach.customInit invoked!");
	}
	
	@PreDestroy
	public void customDestroy() {
		System.out.println("FootballCoach.customDestroy invoked!");
	}

	@Override
	public String getDailyWorkout() {
		return "Today's workout: Do suicide runs to the 40, 50, 60, 80, 100 yard lines";
	}

	@Override
	public String getMotivation() {
		return "The football coach says: " + motivateService.getMotivation();
	}

}
