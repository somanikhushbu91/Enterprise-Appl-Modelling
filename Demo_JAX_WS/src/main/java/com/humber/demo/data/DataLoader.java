package com.humber.demo.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.humber.demo.entities.Artist;
import com.humber.demo.entities.Event;

@Component

public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {



	@Autowired

	private EntityManagerFactory entityManagerFactory;



	@Override

	public void onApplicationEvent(ContextRefreshedEvent event) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();



		entityManager.getTransaction().begin();



		Artist artist = new Artist("The Who");



		Event Event1 = new Event("Wembley Stadium", "July 6, 2019", artist);

		Event Event2 = new Event("Hollywood Bowl", "October 28, 2019", artist);



		artist.add(Event1);

		artist.add(Event2);



		entityManager.persist(artist);



		entityManager.getTransaction().commit();



		entityManager.getTransaction().begin();



		Artist artist2 = new Artist("The Rolling Stones");



		Event Event3 = new Event("Madison Square Garden", "September 12, 2019", artist2);

		Event Event4 = new Event("Dodger Stadium", "November 25, 2019", artist2);



		artist2.add(Event3);

		artist2.add(Event4);



		entityManager.persist(artist2);



		entityManager.getTransaction().commit();

	}



}