
/*Assignment of COMP 1020 
 * Saif Mahmud
 * ID: 7808507
 */
public class Bank {
	private static final int MAX_VALUE = 15;
	private static int cIndex = 0;
	private static int bIndex = 0;
	private BankClient[] clientArray; 
	private BankAccount[] bankAccArray; 
	private long userId;
	private static long id = 1020000000000000l;
	private int accID = 500000;
	
	public Bank() {
		clientArray = new BankClient[MAX_VALUE];
		bankAccArray = new BankAccount[MAX_VALUE];
	}
	public void addBankClient(String fName, String lName) {
		this.userId = id;
		id++;
		BankClient bc = new BankClient (fName, lName, userId);
		clientArray[cIndex] = bc;
		cIndex++;
	}
	public BankClient getBankClient(String fName, String lName) {
		BankClient bc = null;
		Boolean found = false;
		for(int i = 0; i < clientArray.length && !found; i++){
			if(clientArray[i] != null){
			
				if(fName.equals(clientArray[i].getfName()) && lName.equals(clientArray[i].getlName())) {
					found = true;
					bc = clientArray[i];
					
				} else {
					
				}
			}
		}
		return bc;
	}
	public void addChequingAccount(BankClient bcObject, double startingAmount) {
		BankAccount bca = new ChequingAccount(bcObject, startingAmount, accID);
		bankAccArray[bIndex] = bca;
		bIndex++;
		System.out.println("NEW ACCOUNT OF TYPE CHQ CREATED WITH ID = " + accID);
		accID++;
	}
	public void addSavingsAccount(BankClient bcObject, double startingAmount) {
		BankAccount bsa = new SavingsAccount(bcObject, startingAmount, accID);
		bankAccArray[bIndex] = bsa;
		bIndex++;
		System.out.println("NEW ACCOUNT OF TYPE SVG CREATED WITH ID = " + accID);
		accID++;
	}
	public int isValidId(int accid){
		int index = -1;
		for (int i = 0; i < bankAccArray.length ; i++) {
			
			if(bankAccArray[i] != null){
				if(bankAccArray[i].getAccID() == accid) {
					index = i;
				}
			}
			
		}
		return index;
	}

	
	public void payInterest() {
		for (int i = 0; i < bankAccArray.length && (bankAccArray[i] != null); i++) {
			if(bankAccArray[i] instanceof SavingsAccount){
				bankAccArray[i].collectInterest();
			}
		}
	}
	public BankAccount getBankAccount(int index) {
		BankAccount out = bankAccArray[index];
		return out;
	}
	
}
