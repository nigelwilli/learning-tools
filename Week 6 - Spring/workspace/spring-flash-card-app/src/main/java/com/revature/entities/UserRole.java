package com.revature.entities;

public enum UserRole {
	
	ADMIN("ADMIN"), DEV("DEV"), USER("USER"), LOCKED("LOCKED");
	
	private String roleName;
	
	private UserRole(String name) {
		this.roleName = name;
	}
	
	@Override
	public String toString() {
		return this.roleName;
	}

}
