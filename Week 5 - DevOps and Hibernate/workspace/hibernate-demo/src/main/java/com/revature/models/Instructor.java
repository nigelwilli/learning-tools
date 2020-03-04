package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="INSTRUCTORS")
@SequenceGenerator(name="instructor_pk_gen", sequenceName="instructor_seq", allocationSize=1)
public class Instructor {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail details;
	
	@OneToMany(mappedBy="instructor", cascade=CascadeType.ALL)
	private List<Course> courses;
	
	public Instructor() {
		super();
	}
	
	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Instructor(String firstName, String lastName, String email, InstructorDetail details, List<Course> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.details = details;
		this.courses = courses;
	}
	
	public Instructor(int id, String firstName, String lastName, String email, InstructorDetail details, List<Course> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.details = details;
		this.courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getDetails() {
		return details;
	}

	public void setDetails(InstructorDetail details) {
		this.details = details;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		if(courses == null) courses = new ArrayList<>();
		course.setInstructor(this);
		courses.add(course);
	}

	@Override
	public int hashCode() {
		return Objects.hash(courses, details, email, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Instructor))
			return false;
		Instructor other = (Instructor) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(details, other.details)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", details=" + details + "]";
	}

}
