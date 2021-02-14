

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	private static final String INPUT_FILE = "inputPhase4.txt";
	private static Scanner inFile = null;
	private static String currLine;
	private static String [] textParts;
	private static String textFname;
	private static String textLname;
	
	public static void main(String[] args) {
		Bank b = new Bank();
			readInputFile(INPUT_FILE, b);
		}
	public static void readInputFile(String inputFile, Bank b){
		try {
			inFile = new Scanner(new BufferedReader(new FileReader(inputFile)));
			while(inFile.hasNext()) {
				currLine = inFile.nextLine();
					try {
						parseCommand(b);
					} catch (WrongCommandException | InvalidCommandArgsException e) {
						System.out.println(e);
					}	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void parseCommand(Bank b) throws WrongCommandException, InvalidCommandArgsException{

			if(currLine.startsWith("#")) {
				processComment();
			}
			else if(currLine.startsWith("NEW-CLIENT")) {	
				processNewClient(b);		
			}
			else if(currLine.startsWith("GET-CLIENT-INFO")) {
				getClientInfo(textFname, textLname, b);
			}
			else if(currLine.startsWith("NEW-ACCOUNT")) {
				processNewAccount(b);
			}
			else if(currLine.startsWith("GET-ACCOUNT-INFO")){
				findAccountByID(b);
			}
			else if(currLine.startsWith("DEPOSIT")){
				processDiposit(b);
			}
			else if(currLine.startsWith("WITHDRAW")){
				processWithDraw(b);
			}
			else if(currLine.startsWith("INTEREST")){
				processPayInterest(b);
			}
			else if(currLine.isEmpty()) {
				
			}
		//}
		else {
			throw new WrongCommandException(currLine.split(" ")[0]);
		}
	}
	private static void processPayInterest(Bank b) {
		b.payInterest();
		System.out.println("INTEREST WAS PAID");
	}
	private static void processWithDraw(Bank b) {
		textParts = currLine.split(" ");
		int accID = Integer.parseInt(textParts[1]);
		double amount = Double.parseDouble(textParts[2]);
		if(b.getBankAccount(accID) != null) {
			try {
				b.getBankAccount(accID).withdraw(amount);
			} catch (InsufficientFundsException e) {
				System.out.println(e);
			}
		}
		else {
			System.out.println("ACCOUNT NOT FOUND");
		}
	}
	private static void processDiposit(Bank b) throws InvalidCommandArgsException {
		textParts = currLine.split(" ");
		int accID = Integer.parseInt(textParts[1]);
		try {
		double amount = Double.parseDouble(textParts[2]);
		if(b.getBankAccount(accID) != null) {
			b.getBankAccount(accID).deposit(amount);
		}
		else {
			System.out.println("ACCOUNT NOT FOUND");
		}
		}
		catch(NumberFormatException e){
			throw new InvalidCommandArgsException(textParts[2]);
		}
	}
	private static void findAccountByID(Bank b) throws InvalidCommandArgsException {
		textParts = currLine.split(" ");
		try {
			int accID = Integer.parseInt(textParts[1]);
			
			if(b.getBankAccount(accID) != null) {
				b.getBankAccount(accID);
			}
			else {
				System.out.println("ACCOUNT NOT FOUND");
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new InvalidCommandArgsException(textParts[0]);
		}
	}
	private static void processNewAccount(Bank b) {
		textParts = currLine.split(" ");
		try {
		String accType = textParts[1];
		String fName = textParts[2];
		String lName = textParts[3];
		double iniBalance = Double.parseDouble(textParts[4]);
			
			if(accType.matches("CHQ")) {
				b.addChequingAccount(b.getBankClient(fName, lName), iniBalance);
			}
			else if(textParts[1].matches("SVG")) {
				b.addSavingsAccount(b.getBankClient(fName, lName), iniBalance);
			}
		} catch (ArrayIndexOutOfBoundsException aie) {
			//do nothing
		}
	}
	public static void processComment() {
			System.out.println(currLine);
	}
	public static void processNewClient(Bank b) {
			try {
				textParts = currLine.split(" ");
				String commandWord = textParts[0];
					if(textParts.length<3) {
						throw new InvalidCommandArgsException(commandWord);
					}
				textFname = textParts[1];
				textLname = textParts[2];
				b.addBankClient(textFname, textLname);
				System.out.println("NEW CLIENT CREATED");
			} catch (ArrayIndexOutOfBoundsException aie) {
				// do nothing
			} catch (InvalidCommandArgsException e) {
				System.out.println(e);
			}
	}
	public static void getClientInfo(String fName, String lName, Bank b){
			try {
				textParts = currLine.split(" ");
				String commandWord = textParts[0];
					if(textParts.length<3) {
						throw new InvalidCommandArgsException(commandWord);
					}
				textFname = textParts[1];
				textLname = textParts[2];
				b.getBankClient(fName,lName);
			} catch (ArrayIndexOutOfBoundsException aie) {
				//do nothing
			} catch (InvalidCommandArgsException e) {
				System.out.println(e);
			}
	}
}
