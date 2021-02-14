
/*Assignment of COMP 1020 
 * Saif Mahmud
 * ID: 7808507
 */
public class WrongCommandException extends Exception {

	private String wca;
	
	public WrongCommandException(String wca) { 
		this.wca = wca;
	}
	public String toString() {
		return ("WrongCommandException: The command "+ wca +  " is not recognized.");
	}
}
