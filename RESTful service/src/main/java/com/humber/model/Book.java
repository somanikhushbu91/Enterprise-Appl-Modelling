package com.humber.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Book {
	
	@Id
	private int id;
	private String title;
	private String author;
	private String type;
	private double price;
	private int numOfPages;
	private String language;
	private String isbn;

}
