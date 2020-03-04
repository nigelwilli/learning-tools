package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="user_pk_gen", sequenceName="user_seq", allocationSize=1)
@Data public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private String firstName;
	
	@Column 
	private String lastName;
	
	@Column 
	private String username;
	
	@Column 
	private String password;
	
	@Enumerated(EnumType.STRING) 
	private Role role;

}
