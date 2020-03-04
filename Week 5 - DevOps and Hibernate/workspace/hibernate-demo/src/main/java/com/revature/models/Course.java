package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COURSES")
@SequenceGenerator(name="course_pk_gen", sequenceName="course_seq", allocationSize=1)
public class Course {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private String title;
	
	@ManyToOne(cascade= {
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= {
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinTable(
		name="COURSE_STUDENTS",
		joinColumns=@JoinColumn(name="course_id"),
		inverseJoinColumns=@JoinColumn(name="student_id")
	)
	private List<Student> students;
	
	public Course() {
		super();
	}

	public Course(String title) {
		super();
		this.title = title;
	}

	public Course(int id, String title, Instructor instructor) {
		super();
		this.id = id;
		this.title = title;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, instructor, students, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		return id == other.id && Objects.equals(instructor, other.instructor)
				&& Objects.equals(students, other.students) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
}
