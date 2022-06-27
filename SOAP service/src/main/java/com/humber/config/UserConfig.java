package com.humber.config;

import javax.persistence.EntityManagerFactory;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.humber.service.UserServiceImp;

@Configuration
public class UserConfig {
	@Autowired
	private Bus bus;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new UserServiceImp(entityManagerFactory));
		endpoint.publish("/userservice");
		return endpoint;
	}
}
