package com.humber.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.humber.dto.UserByIdRequest;
import com.humber.dto.UserByIdResponse;
import com.humber.dto.UserResponse;
import com.humber.dto.UpdateUserRequest;
import com.humber.entities.User;

public class UserServiceImp implements UserService {
	private EntityManagerFactory entityManagerFactory;

	public UserServiceImp(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public UserResponse getUsers() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select u from User u");

		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();

		entityManager.getTransaction().commit();

		UserResponse response = new UserResponse();
		response.setUsers(users);

		return response;
	}

	@Override
	public UserByIdResponse getUserById(UserByIdRequest userByIdRequest) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("select u from User u where u.id = :id");
		query.setParameter("id", userByIdRequest.getId());

		User user = (User) query.getSingleResult();

		entityManager.getTransaction().commit();

		UserByIdResponse response = new UserByIdResponse();
		response.setUser(user);

		return response;
	}

	@Override
	public int deleteUser(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("delete from User u where u.id = :id");
		query.setParameter("id", id);

		int rowsAffected = query.executeUpdate();

		entityManager.getTransaction().commit();

		return rowsAffected;
	}

	@Override
	public int updateUser(UpdateUserRequest updateUserRequest) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("update User u set u.user = :user where u.id = :id");
		query.setParameter("user", updateUserRequest.getUser());
		query.setParameter("id", updateUserRequest.getId());

		int rowsAffected = query.executeUpdate();

		entityManager.getTransaction().commit();

		return rowsAffected;
	}

	@Override
	public void insertUser(String user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(new User(user));

		entityManager.getTransaction().commit();
	}

}
