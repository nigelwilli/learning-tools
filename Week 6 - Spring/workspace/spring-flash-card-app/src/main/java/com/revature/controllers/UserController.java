package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.ErrorResponse;
import com.revature.entities.AppUser;
import com.revature.security.Secured;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService service) {
		this.userService = service;
	}
	
	@Secured(allowedRoles={"ADMIN", "DEV"})
	@GetMapping(produces="application/json")
	public List<AppUser> getAllUsers(HttpServletRequest req) {
		return userService.getAll();
	}
	
	@ExceptionHandler
    public ErrorResponse handleSecurityException(SecurityException se, HttpServletResponse resp) {
        
        String exMessage = se.getMessage();
        ErrorResponse err = new ErrorResponse();
        err.setMessage(exMessage);
        err.setTimestamp(System.currentTimeMillis());
        
        if(exMessage.contains("forbidden")) {
            resp.setStatus(HttpStatus.FORBIDDEN.value());
            err.setStatus(HttpStatus.FORBIDDEN.value());
        } else if(exMessage.contains("unauthorized")) {
            resp.setStatus(HttpStatus.UNAUTHORIZED.value());
            err.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        
        return err;
    }
	
}
