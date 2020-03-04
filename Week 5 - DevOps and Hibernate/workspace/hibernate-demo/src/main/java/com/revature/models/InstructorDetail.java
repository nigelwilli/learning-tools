package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INSTRUCTOR_DETAILS")
@SequenceGenerator(name="ins_det_pk_gen", sequenceName="instructor_details_seq", allocationSize=1)
public class InstructorDetail {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private String focus;
	
	@Column
	private String hobby;
	
	@OneToOne(mappedBy="details")
	private Instructor instructor;
	
	public InstructorDetail() {
		super();
	}
	
	public InstructorDetail(String focus, String hobby) {
		super();
		this.focus = focus;
		this.hobby = hobby;
	}

	public InstructorDetail(int id, String focus, String hobby, Instructor instructor) {
		super();
		this.id = id;
		this.focus = focus;
		this.hobby = hobby;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
}
