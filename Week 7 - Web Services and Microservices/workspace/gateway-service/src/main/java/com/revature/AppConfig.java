package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.revature.filters.CustomPreFilter;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class AppConfig {
	
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
	
	@Bean
	public CustomPreFilter customPreFilter() {
		return new CustomPreFilter();
	}
}
