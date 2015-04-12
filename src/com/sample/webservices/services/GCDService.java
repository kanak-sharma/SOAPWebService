package com.sample.webservices.services;

import java.util.List;

/**  
 * The Interface GCDService.  
 */ 
public interface GCDService {
	/**  
	 * Gets the list of all the computed greatest common divisors.  
	 *  
	 * @return the list of all the GCD i.e. List<Integer>  
	 */  
	public List<Integer> gcdList() ;
	
	/**  
	 * Gets returns the sum of all computed greatest common divisors.  
	 *  
	 * @return sum of all the GCDs.  
	 */ 
	public int gcdSum();

}
