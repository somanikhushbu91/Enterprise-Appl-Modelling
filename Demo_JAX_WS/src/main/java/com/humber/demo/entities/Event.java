package com.humber.demo.entities;



import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;



@XmlAccessorType(XmlAccessType.NONE)

@Entity

public class Event {



	@Id

	@GeneratedValue

	private int id;

	@XmlElement

	private String venue;

	@XmlElement

	private String date;



	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })

	@JoinColumn(name = "artist_id")

	private Artist artist;



	public Event() {

	}



	public Event(String venue, String date, Artist artist) {

		this.venue = venue;

		this.date = date;

		this.artist = artist;

	}



	public int getId() {

		return id;

	}



	public void setId(int id) {

		this.id = id;

	}



	public String getVenue() {

		return venue;

	}



	public void setVenue(String venue) {

		this.venue = venue;

	}



	public String getDate() {

		return date;

	}



	public void setDate(String date) {

		this.date = date;

	}



	public Artist getArtist() {

		return artist;

	}



	public void setArtist(Artist artist) {

		this.artist = artist;

	}



}