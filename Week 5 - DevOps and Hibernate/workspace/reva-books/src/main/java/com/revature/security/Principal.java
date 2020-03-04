package com.revature.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A security model for holding relevant information about
 * the user making a resource request to the server, including
 * their username and their privilege level.
 * 
 * @author Wezley Singleton
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data public class Principal {
	
	private int id;
	private String subject;
	private String role;

	@JsonIgnore 
	private String token;
	
}
