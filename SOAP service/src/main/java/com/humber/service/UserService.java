package com.humber.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import com.humber.dto.UserByIdRequest;
import com.humber.dto.UserByIdResponse;
import com.humber.dto.UserResponse;
import com.humber.dto.UpdateUserRequest;

@WebService(name = "UserService")
public interface UserService {
	@WebMethod
	public UserResponse getUsers();

	@WebMethod
	public UserByIdResponse getUserById(@XmlElement(required = true) UserByIdRequest userByIdRequest);

	@WebMethod
	public int deleteUser(@WebParam(name = "id") int id);

	@WebMethod
	public int updateUser(@XmlElement(required = true) UpdateUserRequest updateUserRequest);

	@WebMethod
	public void insertUser(@WebParam(name = "user") String user);
}
