package com.humber.dto;

import javax.xml.bind.annotation.XmlType;

import com.humber.entities.User;

@XmlType(name = "UserByIdResponse")
public class UserByIdResponse {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
