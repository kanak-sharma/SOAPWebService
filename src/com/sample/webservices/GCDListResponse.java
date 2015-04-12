package com.sample.webservices;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gcdListResponse")
public class GCDListResponse implements Serializable {
	
	private static final long serialVersionUID = 8838669936187906603L;
	
	@XmlElement(required = true)
	private List<Integer> gcdList;

	public List<Integer> getGcdList() {
		return gcdList;
	}

	public void setGcdList(List<Integer> gcdList) {
		this.gcdList = gcdList;
	}

}