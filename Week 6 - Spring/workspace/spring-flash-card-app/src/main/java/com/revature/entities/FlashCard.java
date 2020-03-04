package com.revature.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FLASH_CARDS")
@SequenceGenerator(name="card_pk_gen" , sequenceName="card_seq", allocationSize=1)
public class FlashCard {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="card_pk_gen")
	private int id;

	@Column(nullable=false, unique=true)
	private String question;
	
	@Column(nullable=false)
	private String answer;
	
	public FlashCard() {
		super();
	}

	public FlashCard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public FlashCard(int id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(answer, id, question);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FlashCard))
			return false;
		FlashCard other = (FlashCard) obj;
		return Objects.equals(answer, other.answer) && id == other.id && Objects.equals(question, other.question);
	}

	@Override
	public String toString() {
		return "FlashCard [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}
	
}
