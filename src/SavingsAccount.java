
public class SavingsAccount extends BankAccount {
	private static final double TRANSAC_FEE = 4.95;
	private static final double INTEREST_RATE = 0.015/12;
	
	public SavingsAccount(BankClient accOwner, double balance, int accID) {
		super(accOwner, balance, accID);
		
	}
	public void collectInterest() {
		this.balance = balance + (balance*INTEREST_RATE);
	}
	public String toString() {
		String x = super.toString();
		String[] strArr = x.split(" ");
		String out = "Savings " + strArr[1] + " " + strArr[2] + " " + strArr[3] + "\n"
					 + strArr[4] + " " + strArr[5] + " " + strArr[6] + "\n"
					 + strArr[7] + " " + strArr[8];
		return out;
	}
	public void withdraw(double amount) throws InsufficientFundsException{
		if(amount < balance) {
		balance = balance - amount;
		balance = balance - TRANSAC_FEE;
		}
		else {
			throw new InsufficientFundsException();
		}
	}
	public void payInterest() {
		for (int i = 0; i < bankAccArray.length && (bankAccArray[i] != null); i++) {
			bankAccArray[i].collectInterest();
		}
	}
}
