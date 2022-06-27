package com.humber.saaj;

import java.util.Scanner;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class SAAJClientCalculateInterest {
	private static SOAPMessage createSoapRequest() throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
		soapEnvelope.addNamespaceDeclaration("end", "http://endpoint.humber.com/");
		SOAPBody soapBody = soapEnvelope.getBody();
		SOAPElement soapElement = soapBody.addChildElement("getInterest", "end");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter principal amount: ");
		String p = sc.next();
		SOAPElement element1 = soapElement.addChildElement("arg0");
		System.out.println("Enter rate interest: ");
		String r = sc.next();
		SOAPElement element2 = soapElement.addChildElement("arg1");
		System.out.println("Enter time period in years: ");
		String n = sc.next();
		SOAPElement element3 = soapElement.addChildElement("arg2");
		element1.addTextNode(p);
		element2.addTextNode(r);
		element3.addTextNode(n);
		soapMessage.saveChanges();
		System.out.println("----------SOAP Request------------");
		soapMessage.writeTo(System.out);
		sc.close();
		return soapMessage;
	}

	private static void createSoapResponse(SOAPMessage soapResponse) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		System.out.println("\n----------SOAP Response-----------");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
	}

	public static void main(String args[]) {
		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			String url = "http://localhost:8080/endpoint/soapHandler?wsdl";
			SOAPMessage soapRequest = createSoapRequest();
			// hit soapRequest to the server to get response
			SOAPMessage soapResponse = soapConnection.call(soapRequest, url);
			createSoapResponse(soapResponse);
			soapConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}