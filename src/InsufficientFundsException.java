/*
 * Author: Saif Mahmud
 * Date: October 20, 2017
 * 
 */
public class InsufficientFundsException extends Exception {
	
	public InsufficientFundsException() {
		
	}
	public String toString() {
		return ("Insufficient funds for the withdrawal");
	}
}
