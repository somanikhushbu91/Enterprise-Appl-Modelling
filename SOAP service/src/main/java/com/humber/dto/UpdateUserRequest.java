package com.humber.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "UpdateUserRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateUserRequest {
	@XmlElement(required = true)
	private int id;
	
	@XmlElement(required = true)
	private String user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
