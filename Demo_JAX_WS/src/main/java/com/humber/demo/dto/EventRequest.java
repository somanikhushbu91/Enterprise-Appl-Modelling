package com.humber.demo.dto;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "EventRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventRequest {
	@XmlElement(required = true)
    private String artistName;
 
    public String getArtistName() {
        return artistName;
    }
 
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
	
}
