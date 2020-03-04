package com.revature.entities;

public enum Role {
	
	ADMIN("ADMIN"), DEV("DEV"), USER("USER"), LOCKED("LOCKED");
	
	private String roleName;
	
	private Role(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		return roleName;
	}

}
