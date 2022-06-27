package com.humber.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.humber.demo.dto.EventRequest;
import com.humber.demo.dto.EventResponse;
import com.humber.demo.entities.Artist;

@Service
public class EventServiceImpl implements EventService{
	private EntityManagerFactory entityManagerFactory;
	

	public EventServiceImpl(EntityManagerFactory entityManagerFactory) {
			this.entityManagerFactory = entityManagerFactory;
		// TODO Auto-generated constructor stub
	}


	@Override
	public EventResponse getEventInfo(EventRequest request) {
		// TODO Auto-generated method stub
		String name = request.getArtistName();
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select a from Artist a where a.name = :name");
		query.setParameter("name", name);
		Artist artist = (Artist) query.getSingleResult();
		entityManager.getTransaction().commit();
		
		EventResponse response = new EventResponse();
		response.setArtist(artist);
		return response;
	}

}
