
public class InvalidCommandArgsException extends Exception {

	private String icae;
	
	public InvalidCommandArgsException(String icae) {
		this.icae = icae;
	}
	public String toString() {
		return ("InvalidCommandArgsException: "+ icae +  ": First or last name is missing.");
	}
}
