
/*
 * Author: 	Saif Mahmud
 * Date:	October 20, 2017
 * Purpose:	Abstract class for BankAccount
 */

public abstract class BankAccount extends Bank {
	private BankClient accOwner;
	protected double balance;
	private int accID;

	public BankAccount(BankClient accOwner, double balance, int accID) {
		this.accOwner = accOwner;
		this.balance = balance;
		this.accID = accID;
	}

	public abstract void collectInterest();

	public BankClient getAccOwner() {
		return accOwner;
	}

	public double getBalance() {
		return balance;
	}

	public int getAccID() {
		return accID;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount < balance) {
			balance = balance - amount;
		} else {
			throw new InsufficientFundsException();
		}
	}

	public String toString() {
		String[] thisArray;
		String theOutputString = accOwner.toString();
		thisArray = theOutputString.split(" ");
		String fName = thisArray[0];
		String lName = thisArray[1];
		return ("Chequing account id: " + getAccID() + " Owner: " + fName + " " + lName + "\n"
				+ "Balance : $" + String.format("%.2f", getBalance()));
	}

}
