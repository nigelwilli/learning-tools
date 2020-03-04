package com.revature.services;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserRepository;

public class UserService {

	private static Logger log = LogManager.getLogger(UserService.class);
	
	private UserRepository userRepo = new UserRepository();
	
	public List<User> getAllUsers() {
		log.info("UserService.getAllUsers invoked");
		return userRepo.getAll();
	}
	
	public List<User> getUsersByRole(String role) {
		log.info("UserService.getUsersByRole invoked");
		
		if(!Arrays.asList(Role.values()).contains(Role.valueOf(role.toUpperCase()))) return null;

		return userRepo.getUsersByRole(Role.valueOf(role.toUpperCase()));
		
	}
	
	public User getUserById(int userId) {
		log.info("UserService.getUserById invoked");
		User user = userRepo.getById(userId);
		if(user == null) throw new UserNotFoundException("No user found with provided id.");
		return user;
	}
	
	public User getUserByUsername(String username) {
		log.info("UserService.getUserByUsername invoked");
		
		if(username == null || username.equals("")) {
			log.warn("Non-value provided for username");
			return null;
		}
		
		return userRepo.getUserByUsername(username);
		
	}
	
	public User login(String username, String password) {
		log.info("UserService.login invoked");
		
		if(username == null || username.equals("") || 
			password == null || password.equals("")) 
		{
			log.warn("Non-value provided for username and/or password");
			return null;
		}
		
		return userRepo.getUserByCredentials(username, password);
	}
	
	public User register(User newUser) {
		log.info("UserService.register invoked");

		String username = newUser.getUsername();
		
		if(!validateUserFields(newUser)) {
			log.warn("Invalid fields found on user object");
			return null;
		}
		
		// Validation for username availability
		boolean usernameAvailable = userRepo.getUserByUsername(username) == null;
		if(!usernameAvailable) {
			log.warn("Provided username on new user is already taken - user not created");
			return null;
		}

		// Ensure that all newly registered users are of type USER
		log.info("Setting role of new user to \"USER\"");
		newUser.setRole(Role.USER);
		
		return userRepo.save(newUser);
		
	}
	
	public boolean updateUser(User updatedUser) {
		log.info("UserService.updateUser invoked");
		
		if(!validateUserFields(updatedUser)) {
			log.warn("Invalid fields found on user object");
			return false;
		}
		
		return userRepo.update(updatedUser);
	}
	
	public boolean deleteUser(int userId) {
		log.info("UserService.deleteUser invoked");
		return userRepo.deleteById(userId);
	}
	
	protected boolean validateUserFields(User user) {
		
		// Validation for correct user field values
		if(user.getUsername().trim().equals("") || user.getUsername() == null) return false;
		if(user.getPassword().trim().equals("") || user.getPassword() == null) return false;
		if(user.getFirstName().trim().equals("") || user.getFirstName() == null) return false;
		if(user.getLastName().trim().equals("") || user.getLastName() == null) return false;
		
		return true;
		
	}
}
