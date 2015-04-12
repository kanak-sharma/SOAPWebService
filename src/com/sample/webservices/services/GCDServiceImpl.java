package com.sample.webservices.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

/**  
 * The Class GCDServiceImpl.  
 */  
@Service
public class GCDServiceImpl {
	/**  
	 * Gets the list of all the computed greatest common divisors
	 *  
	 * @return the list of all the GCD   
	 */  
	public List<Integer> gcdList() { 
		/* hard coded the List of GCD - in reality this data would be retrieved from a database */  
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		queue.add(2);
		queue.add(3);
		queue.add(6);
		queue.add(4);
		return queue;  
	}  

	/**  
	 * Gets returns the sum of all computed greatest common divisors.  
	 *  
	 * @return sum of all the GCDs.  
	 */ 
	public int gcdSum() {  
		int sum =0;
		for(int i=0; i < gcdList().size(); i++){
			sum += gcdList().get(i);
		}
		return sum;
	}

}
