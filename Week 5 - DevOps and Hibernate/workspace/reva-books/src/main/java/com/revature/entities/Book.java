package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="book_pk_gen", sequenceName="book_seq", allocationSize=1)
@Data public class Book {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private String isbn;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private String genre;
	
	@Column
	private double price;
	
	@Column
	private int numberInStock;

}
