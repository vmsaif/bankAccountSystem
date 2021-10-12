
/*Assignment of COMP 1020 
 * Saif Mahmud
 * ID: 7808507
 */
public class Bank {
	private static final int MAX_VALUE = 15;
	private int index = 0;
	private BankClient[] clientArray; 
	protected BankAccount[] bankAccArray; 
	private long userId;
	private static long id = 1020000000000000l;
	private int accID = 50000;
	
	public Bank() {
		clientArray = new BankClient[MAX_VALUE];
		bankAccArray = new BankAccount[MAX_VALUE];
	}
	public void addBankClient(String fName, String lName) {
		this.userId = id;
		id++;
		BankClient bc = new BankClient (fName, lName, userId);
		clientArray[index] = bc;
	}
	public BankClient getBankClient(String fName, String lName) {
		BankClient bc = null;
		if(fName == clientArray[index].getfName() && 
				lName == clientArray[index].getlName()) {
			bc = clientArray[index];
			System.out.println(bc);
		}
		else {
			System.out.println("CLIENT NOT FOUND");
		}
		return bc;
	}
	public void addChequingAccount(BankClient bcObject, double startingAmount) {
		BankAccount bca = new ChequingAccount(bcObject, startingAmount, accID);
		bankAccArray[index] = bca;
		System.out.println("NEW ACCOUNT OF TYPE CHQ CREATED WITH ID = " + accID);
		accID++;
	}
	public void addSavingsAccount(BankClient bcObject, double startingAmount) {
		BankAccount bsa = new SavingsAccount(bcObject, startingAmount, accID);
		bankAccArray[index] = bsa;
		System.out.println("NEW ACCOUNT OF TYPE SVG CREATED WITH ID = " + accID);
		accID++;
	}
	public BankAccount getBankAccount(int accid) {
		BankAccount out = null;
		for (int i = 0; i < bankAccArray.length && (bankAccArray[i] != null); i++) {
			if(bankAccArray[i].getAccID() == accid) {
				out = bankAccArray[i];
			}
		}
		return out;
	}
	public void payInterest() {
		
	}
}
