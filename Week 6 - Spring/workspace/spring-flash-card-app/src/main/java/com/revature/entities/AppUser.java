package com.revature.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.revature.dtos.Principal;
import com.revature.util.RegexUtil;

@NamedQueries({
	@NamedQuery(name="getUserByCredentials", query="from AppUser u where u.username = :un and u.password = :pw")
})

@Entity
@Table(name="APP_USERS")
@SequenceGenerator(name="app_user_gen", sequenceName="app_user_seq", allocationSize=1)
public class AppUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="app_user_gen")
	private int id;
	
	@NotNull
	@Pattern(regexp=RegexUtil.emailRegex)
	@Column(nullable=false)
	private String email;
	
	@NotNull
	@Column(nullable=false)
	private String username;
	
	@NotNull
	@Pattern(regexp=RegexUtil.passwordRegex)
	@Column(nullable=false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	public AppUser() {
		super();
	}

	public AppUser(String email, String username, String password, UserRole role) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public AppUser(int id, String email, String username, String password, UserRole role) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public void copyFields(AppUser userToCopy) {
		this.email = userToCopy.email;
		this.username = userToCopy.username;
		this.password = userToCopy.password;
		this.role = userToCopy.role;
	}
	
	public Principal extractPrincipal() {
		return new Principal(this.id, this.username, this.role.toString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AppUser))
			return false;
		AppUser other = (AppUser) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(password, other.password)
				&& role == other.role && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", role=" + role + "]";
	}
	
}
