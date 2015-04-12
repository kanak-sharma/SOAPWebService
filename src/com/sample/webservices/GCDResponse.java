package com.sample.webservices;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gcdResponse")
public class GCDResponse implements Serializable {
	
	private static final long serialVersionUID = 8838669936197906602L;
	
	@XmlElement(required = true)
	private int gcd;

	public int getGcd() {
		return gcd;
	}

	public void setGcd(int gcd) {
		this.gcd = gcd;
	}

}