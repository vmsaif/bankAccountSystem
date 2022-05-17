
public class ChequingAccount extends BankAccount {

	private static final double TRANSAC_FEE = 4.95;
	public ChequingAccount(BankClient accOwner, double balance, int accID) {
		super(accOwner, balance, accID);
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
	public String toString() {
		String x = super.toString();
		String[] strArr = x.split(" ");
		String out = strArr[0] + " " + strArr[1] + " " + strArr[2] + " " + strArr[3] + "\n"
					 + strArr[4] + " " + strArr[5] + " " + strArr[6] + "\n"
					 + strArr[7] + " " + strArr[8];
		return out;
	}
	public void payInterest() {
		
	}
}
