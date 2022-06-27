package com.humber.client;

import java.util.Scanner;

import com.humber.service.CalculateInterest;
import com.humber.service.CalculateInterestImplService;


public class CalculateInterestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CalculateInterestImplService calService = new CalculateInterestImplService();
		CalculateInterest calInterest = calService.getCalculateInterestImplPort();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter principal amount: ");
		int p = sc.nextInt();
		System.out.println("Enter rate: ");
		double r = sc.nextDouble();
		System.out.println("Enter term: ");
		int n = sc.nextInt();
		
		double result = (double)calInterest.getInterest(p,r,n);
		System.out.println(result);
		sc.close();
	}

}
