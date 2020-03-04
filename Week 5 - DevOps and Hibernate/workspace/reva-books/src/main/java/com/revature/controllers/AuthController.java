package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.Credentials;
import com.revature.dtos.ErrorResponse;
import com.revature.entities.User;
import com.revature.security.JwtConfig;
import com.revature.security.JwtGenerator;
import com.revature.security.Principal;
import com.revature.services.UserService;
import com.revature.web.Handler;
import com.revature.web.HandlerContext;
import com.revature.web.HttpMethod;
import com.revature.web.HttpStatus;
import com.revature.web.annotations.Controller;
import com.revature.web.annotations.RequestMapping;

import lombok.extern.log4j.Log4j2;

/**
 * Controller used to process authentication requests to 
 * the web application.
 * 
 * @author Wezley Singleton
 *
 */
@Log4j2
@Controller(
	name="AuthController", 
	uri="/auth",
	qualifiedName="com.revature.controllers.AuthController"
)
public class AuthController implements Handler {
	
	private final UserService userService = new UserService();
	
	@Override
	public Object invoke(HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp) {
		log.info("AuthController invoked");
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			if(hctx.getMethod().equals(HttpMethod.POST)) {
				log.info("Post request received, extracting credentials object");
				Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
				
				log.info("Using provided credentials to authenticate");				
				Principal payload = authenticate(creds);
				
				if(payload == null) resp.setStatus(401);
				else {
					resp.setHeader(JwtConfig.HEADER, JwtConfig.PREFIX + payload.getToken());
					resp.setStatus(200);
				}
				
				log.info("Setting handler context for request to done");
				hctx.setDone(true);
				
				return payload;
			}
			
			log.info("No " + hctx.getMethod() + " mapping found for this controller");
			
		} catch (IOException ioe) {
			log.warn(HttpStatus.BAD_REQUEST_400.toString());
			log.error(ioe.getMessage());
			resp.setStatus(400);
			return new ErrorResponse(400, HttpStatus.BAD_REQUEST_400.toString(), System.currentTimeMillis());
		}
		
		resp.setStatus(401);
		return null;
	}
	
	/**
	 * Used to service authentication requests. Currently only works with a 
	 * predefined dummy user value.
	 * 
	 * @param creds
	 * @return A principal object if successful, otherwise null.
	 */
	@RequestMapping(requestMethod=HttpMethod.POST, produces="application/json", consumes="application/json")
	public Principal authenticate(Credentials creds) {
		
		if(creds == null || creds.getUsername() == null || creds.getPassword() == null) {
			throw new RuntimeException(HttpStatus.BAD_REQUEST_400.toString());
		}
		
		User authenticatedUser = userService.login(creds.getUsername(), creds.getPassword());
		
		if(authenticatedUser == null) {
			log.warn("No user found with provided credentials");
			return null;
		}
		
		log.info("User found with provided credentials, creating principal payload");
		Principal principal = new Principal();
		principal.setId(authenticatedUser.getId());
		principal.setSubject(authenticatedUser.getUsername());
		principal.setRole(authenticatedUser.getRole().toString());

		String token = JwtGenerator.createJwt(principal);
		principal.setToken(token);
		
		return principal;
		
	}

}
