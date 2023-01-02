/*
 * Author: Saif Mahmud
 * Date: October 20, 2017
 */
public class InvalidCommandArgsException extends Exception {

	private String icae;
	
	public InvalidCommandArgsException(String icae) {
		this.icae = icae;
	}
	public String toString() {
		return ("InvalidCommandArgsException: "+ icae +  ": First or last name or ID is missing.");
	}
}
