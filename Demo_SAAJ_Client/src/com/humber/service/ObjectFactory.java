
package com.humber.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.humber.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetInterest_QNAME = new QName("http://service.humber.com/", "getInterest");
    private final static QName _GetInterestResponse_QNAME = new QName("http://service.humber.com/", "getInterestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.humber.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInterest }
     * 
     */
    public GetInterest createGetInterest() {
        return new GetInterest();
    }

    /**
     * Create an instance of {@link GetInterestResponse }
     * 
     */
    public GetInterestResponse createGetInterestResponse() {
        return new GetInterestResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInterest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.humber.com/", name = "getInterest")
    public JAXBElement<GetInterest> createGetInterest(GetInterest value) {
        return new JAXBElement<GetInterest>(_GetInterest_QNAME, GetInterest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInterestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.humber.com/", name = "getInterestResponse")
    public JAXBElement<GetInterestResponse> createGetInterestResponse(GetInterestResponse value) {
        return new JAXBElement<GetInterestResponse>(_GetInterestResponse_QNAME, GetInterestResponse.class, null, value);
    }

}
