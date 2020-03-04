package com.revature;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.models.Coach;
import com.revature.models.FootballCoach;

public class SpringDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Creating bean container...");
		
		try(AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class)) {
			
			System.out.println("Bean container created!");
			
			// Retrieve the coach implementation from the container using its bean name
			System.out.println("Requesting coach bean...");
			Coach coach = container.getBean("myCoach", Coach.class);
			
			// Call some methods on the retrieved bean
			System.out.println(coach.getDailyWorkout());
			System.out.println(coach.getMotivation());
			
			//---------------------------------------------------------------------
			
			// Obtain another reference for our coach bean
			Coach assistantCoach = container.getBean("myCoach", Coach.class);
			System.out.println(coach);
			System.out.println(assistantCoach);
			System.out.println(coach == assistantCoach);
			
			//----------------------------------------------------------------------
			
			// Retrieve the FootballCoach bean from the container and call some methods on it
			FootballCoach footballCoach = container.getBean("myFootballCoach", FootballCoach.class);
			System.out.println(footballCoach.getDailyWorkout());
			System.out.println(footballCoach.getMotivation());
			System.out.println(footballCoach.getEmail());
			System.out.println(footballCoach.getTeam());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
