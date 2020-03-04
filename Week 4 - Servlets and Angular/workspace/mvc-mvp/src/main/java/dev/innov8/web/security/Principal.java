package dev.innov8.web.security;

import java.util.Objects;

/**
 * A security model for holding relevant information about
 * the user making a resource request to the server, including
 * their username and their privilege level.
 * 
 * @author Wezley
 *
 */
public class Principal {
	
	private int id;
	private String subject;
	private String role;
	
	public Principal() {
		super();
	}

	public Principal(int id, String subject, String role) {
		super();
		this.id = id;
		this.subject = subject;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, role, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Principal))
			return false;
		Principal other = (Principal) obj;
		return id == other.id && Objects.equals(role, other.role) && Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		return "Principal [id=" + id + ", subject=" + subject + ", role=" + role + "]";
	}
	
}
