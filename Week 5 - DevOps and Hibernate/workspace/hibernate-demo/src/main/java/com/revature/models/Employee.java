package com.revature.models;

import java.util.Date;
import java.util.Objects;

public class Employee {
	
	private int id;
	private String name;
	private String role;
	private Date insertTime;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, String role, Date insertTime) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.insertTime = insertTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, insertTime, name, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(insertTime, other.insertTime) && Objects.equals(name, other.name)
				&& Objects.equals(role, other.role);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", insertTime=" + insertTime + "]";
	}
	
}
