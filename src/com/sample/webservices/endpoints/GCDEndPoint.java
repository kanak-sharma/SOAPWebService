package com.sample.webservices.endpoints;  
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sample.webservices.GCDListResponse;
import com.sample.webservices.GCDSumResponse;
import com.sample.webservices.GCDResponse;
import com.sample.webservices.services.GCDService;
/**  
 * The Class GCDService.  
 */  

@Endpoint
public class GCDEndPoint {

	private static final String NAMESPACE_URI = "http://com/sample/webservices/gcdservice"; 

	@Autowired  
	private GCDService gcdService;  

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "gcd")
	
	public @ResponsePayload GCDResponse gcd() throws IOException { 
		GCDResponse gcdResponse = new GCDResponse();
		int gcd=0;
		//	returns the greatest common divisor* of the two integers at the head of the elements will subsequently be discarded from the queue and the head replaced by the next two in line.
		Queue<Integer> queue = getQueueElements();

		//Pop a couple of entries from the stack
		System.out.println("Lets pop 2 elements from the stack");
		int count = 0;
		LinkedList<Integer> tempqueue = new LinkedList<Integer>();
		while(!queue.isEmpty() && count<2) {
			Integer poll = queue.poll();
			System.out.println("Popped "+poll);
			tempqueue.add(poll);
			count++;
		}
		System.out.print("Elements on the temp queue: "+ tempqueue +"\n");
		System.out.print("Elements on the Actual queue: "+ queue +"\n");
		int number1= tempqueue.get(0);
		int number2= tempqueue.get(1);

		gcd = findGCD(number1,number2);
		System.out.println("GCD of two numbers " + number1 +" and " + number2 +" is :" + gcd);
		gcdResponse.setGcd(gcd);
		return gcdResponse;
	} 

	/**
	 * Method will returns a list of all the computed greatest common divisors. 
	 * @return GCD List
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GcdList")
	public @ResponsePayload GCDListResponse gcdList() {
		GCDListResponse gcdListResponse = new GCDListResponse();
		List<Integer> gcdList = gcdService.gcdList();
		gcdListResponse.setGcdList(gcdList);
		return gcdListResponse;
	}

	/**
	 * Method will returns the sum of all computed greatest common divisors. 
	 * @return GCD Sum
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GcdSum")
	public @ResponsePayload GCDSumResponse gcdSum() {
		GCDSumResponse gcdSumResponse = new GCDSumResponse();
		int sum = gcdService.gcdSum();
		gcdSumResponse.setSum(sum);
		return gcdSumResponse;
	}

	public void setGCDService(GCDService gcdService) {  
		this.gcdService = gcdService;  
	}  

	private int findGCD(int number1, int number2) {
		if(number2 == 0){
			return number1;
		}
		return findGCD(number2, number1%number2);
	}

	@SuppressWarnings("resource")
	private Queue<Integer> getQueueElements() throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		//Pushing integers onto the queue
		System.out.println("Please enter an integer values to push onto the queue - OR - 'q' to Quit");
		while(scan.hasNextInt()) {
			int i = scan.nextInt();
			queue.add(i);
		}
		System.out.print("Elements on the queue: "+ queue +"\n");
		return queue;
	}  

}  