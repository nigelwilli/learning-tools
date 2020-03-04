package dev.innov8.models;

/**
 * An enumeration used to indicate the privilege level of a
 * given user.
 * 
 * @author Wezley Singleton
 *
 */
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
