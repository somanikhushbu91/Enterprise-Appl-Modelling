
package com.humber.demo.entities;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity

public class Artist {

	@Id

	@GeneratedValue

	private int id;

	@Column(unique = true, nullable = false)

	private String name;

	@OneToMany(mappedBy = "artist", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,

			CascadeType.REFRESH })

	private List<Event> events;

	public Artist() {

	}

	public Artist(String name) {

		this.name = name;

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

	public List<Event> getEvents() {

		return events;

	}

	public void setEvents(List<Event> events) {

		this.events = events;

	}

	public void add(Event event) {

		if (events == null) {

			events = new ArrayList<>();

		}

		events.add(event);

	}

}