package com.humber.endpoint;

import javax.xml.ws.Endpoint;

import com.humber.service.CalculateInterestImpl;

public class CalculateInterestPublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Endpoint.publish("http://localhost:8080/endpoint/soapHandler", new CalculateInterestImpl());
	}

}
