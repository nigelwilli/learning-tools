package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dtos.Credentials;
import com.revature.entities.AppUser;
import com.revature.exceptions.BadRequestException;
import com.revature.repos.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository repo) {
		this.userRepo = repo;
	}
	
	@Transactional(readOnly=true)
	public List<AppUser> getAll() {
		return userRepo.getAll();
	}
	
	@Transactional(readOnly=true)
	public AppUser getByCredentials(Credentials creds) {
		
		if(creds == null || creds.getUsername() == null || creds.getPassword() == null
				|| creds.getUsername().equals("") || creds.getPassword().equals(""))
		{
			throw new BadRequestException("Invalid credentials object provided");
		}
		
		AppUser retrievedUser = userRepo.getUserByUsernameAndPassword(creds.getUsername(), creds.getPassword());
		
		if(retrievedUser == null) {
			throw new SecurityException("No user found with provided credentials");
		}
		
		return retrievedUser;
			
	}
	
}
