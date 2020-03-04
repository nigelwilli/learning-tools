package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dtos.ErrorResponse;
import com.revature.entities.User;
import com.revature.security.Principal;
import com.revature.services.UserService;
import com.revature.web.Handler;
import com.revature.web.HandlerContext;
import com.revature.web.HttpStatus;
import com.revature.web.annotations.Controller;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller(
	name="UserController", 
	uri="/users",
	qualifiedName="com.revature.controllers.UserController"
)
public class UserController implements Handler {

	private final UserService userService = new UserService();
	
	@Override
	public Object invoke(HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp) {
		log.info("UserController invoked");
		
		try {
			
			switch(hctx.getMethod().toString()) {
			
			case "GET":
				
				log.info("Get request received, obtain principal from request");
				Principal principal = (Principal) req.getAttribute("principal");
				
				if(principal == null) {
					log.warn("No principal object found on request.");
					resp.setStatus(401);
					return new ErrorResponse(401, HttpStatus.UNAUTHORIZED_401.toString(), System.currentTimeMillis());
				}
				
				if(!principal.getRole().equalsIgnoreCase("ADMIN")) {
					log.warn("Unauthorized access attempt made.");
					resp.setStatus(403);
					return new ErrorResponse(403, HttpStatus.FORBIDDEN_403.toString(), System.currentTimeMillis());
				}
				
				log.info("Authorized request received, determining handler method");
				if(hctx.getPathSegments().length >= 1) {
					hctx.setDone(true);
					return getAllUsers();
				}
				
				else if(hctx.getPathSegments().length > 2) {
					String queryValue = hctx.getPathSegments()[2];
					hctx.setDone(true);
					
					switch(hctx.getPathSegments()[1]) {
					

					case "id":
						return getUsersByRole(queryValue);
					case "role":
						return getUserById(Integer.parseInt(queryValue));
					case "username":
						return getUserByUsername(queryValue);
					}
				}
				
				break;
				
			case "POST":
				break;
			case "PUT":
				break;
			case "DELETE":
				break;
			default:
				log.info("No " + hctx.getMethod() + " mapping found for this controller");
			
			}
			
		} catch (Exception e) {
			log.warn(HttpStatus.BAD_REQUEST_400.toString());
			e.printStackTrace();
			resp.setStatus(400);
			return new ErrorResponse(400, HttpStatus.BAD_REQUEST_400.toString(), System.currentTimeMillis());
		}
		
		
		resp.setStatus(400);
		return null;
	}
	
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	public List<User> getUsersByRole(String role) {
		return userService.getUsersByRole(role);
	}
	
	public User getUserById(int id) {
		return userService.getUserById(id);
	}
	
	public User getUserByUsername(String username) {
		return userService.getUserByUsername(username);
	}

}
