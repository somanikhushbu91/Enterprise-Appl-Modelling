package com.humber.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CalculateInterest {

	@WebMethod
	public double getInterest(int p, double r, int n);
}
