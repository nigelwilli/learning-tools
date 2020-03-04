package com.revature.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Serves as a convenience object for holding user credentials, which
 * are extracted from incoming client requests for authentication.
 * 
 * @author Wezley Singleton
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data public class Credentials {
	
	private String username;
	private String password;
	
}
