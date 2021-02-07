
/*Assignment of COMP 1020 
 * Saif Mahmud
 * ID: 7808507
 */
public class BankClient {
	private String fName;
	private String lName; 
	private long userId;
	
	public BankClient(String fName, String lName, long userId) {
		this.fName = fName;
		this.lName = lName;
		this.userId = userId;
	}
	public String getfName() {
		return this.fName;
	}
	public String getlName() {
		return this.lName;
	}
	public long getId() {
		return this.userId;
	}
	public String toString() {
		
		return (this.fName + " " + this.lName + " " + "(" + this.userId +")");
	}
	
}
