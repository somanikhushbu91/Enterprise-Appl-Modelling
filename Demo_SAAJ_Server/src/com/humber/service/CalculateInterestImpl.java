package com.humber.service;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface = "com.humber.service.CalculateInterest")
@HandlerChain(file="../handler/handler-chain.xml")
public class CalculateInterestImpl implements CalculateInterest{

	@Override
	public double getInterest(int p, double r, int n) {
		// TODO Auto-generated method stub
		double result;
		
		System.out.println("Principal amount: " + p);
		System.out.println("Rate: " + r);
		System.out.println("Term: " + n);
		result= (p*r*n)/100;
		System.out.println("Calculated Interest: " + result);
		return result;
	}
	

}
