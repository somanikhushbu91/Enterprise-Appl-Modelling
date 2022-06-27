package com.humber.demo.service;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import com.humber.demo.dto.EventRequest;
import com.humber.demo.dto.EventResponse;

@WebService
public interface EventService {

	public EventResponse getEventInfo(@XmlElement(required = true) EventRequest request);
}
