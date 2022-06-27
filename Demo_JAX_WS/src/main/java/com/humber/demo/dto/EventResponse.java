package com.humber.demo.dto;

import javax.xml.bind.annotation.XmlType;

import com.humber.demo.entities.Artist;
@XmlType(name="EventResponse")
public class EventResponse{
    private Artist artist;

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
                      
}
