package com.revature.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Credentials;
import com.revature.dtos.ErrorResponse;
import com.revature.dtos.Principal;
import com.revature.exceptions.BadRequestException;
import com.revature.security.JwtConfig;
import com.revature.security.JwtGenerator;
import com.revature.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserService userService;
	
	@Autowired
	public AuthController(UserService service) {
		this.userService = service;
	}
	
	@PostMapping(produces="application/json", consumes="application/json")
	public Principal authenticate(@RequestBody @Valid Credentials creds, HttpServletResponse resp) {
		Principal payload = userService.getByCredentials(creds).extractPrincipal();
		resp.setHeader(JwtConfig.HEADER, JwtConfig.PREFIX + JwtGenerator.createJwt(payload));
		return payload;
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleBadRequest(BadRequestException bre) {
		ErrorResponse err = new ErrorResponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(bre.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		return err;
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorResponse handleFailedAuthentication(SecurityException se) {
		ErrorResponse err = new ErrorResponse();
		err.setStatus(HttpStatus.UNAUTHORIZED.value());
		err.setMessage(se.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		return err;
	}
}
