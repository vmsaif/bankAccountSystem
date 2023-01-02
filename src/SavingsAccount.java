/*
 * Author: Saif Mahmud
 * Date: October 20, 2017
 */
public class SavingsAccount extends BankAccount {
	
	private static final double INTEREST_RATE = 1.5/100;
	
	public SavingsAccount(BankClient accOwner, double balance, int accID) {
		super(accOwner, balance, accID);
		
	}

	@Override
	public void collectInterest() {
		this.balance = balance + (balance * INTEREST_RATE);
	}
	public String toString() {
		String x = super.toString();
		String[] strArr = x.split(" ");
		String out = "Savings " + strArr[1] + " " + strArr[2] + " " + strArr[3] + "\n"
					 + strArr[4] + " " + strArr[5] + " " + strArr[6] + strArr[7] + " " + strArr[8];
		return out;
	}
	public void withdraw(double amount) throws InsufficientFundsException{
		if(amount < balance) {
			balance = balance - amount;
		}
		else {
			throw new InsufficientFundsException();
		}
	}
	
}
