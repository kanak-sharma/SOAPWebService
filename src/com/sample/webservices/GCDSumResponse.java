package com.sample.webservices;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gcdSumResponse")
public class GCDSumResponse implements Serializable {
	
	private static final long serialVersionUID = 8838669936197906603L;
	
	@XmlElement(required = true)
	private int sum;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}