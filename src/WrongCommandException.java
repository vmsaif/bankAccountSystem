
public class WrongCommandException extends Exception {

	private String wca;
	
	public WrongCommandException(String wca) { 
		this.wca = wca;
	}
	public String toString() {
		return ("WrongCommandException: The command "+ wca +  " is not recognized.");
	}
}
