package com.humber.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlType;

import com.humber.entities.User;

@XmlType(name = "UserResponse")
public class UserResponse {
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
