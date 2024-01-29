# Bank Account System

[![Hits](https://hits.sh/github.com/vmsaif/bankAccountSystem.svg?label=Visits&color=100b75)](https://hits.sh/github.com/vmsaif/bankAccountSystem/)

This Java program simulates the operations of a bank by reading and processing instructions from a text file. Designed with object-oriented principles, the system is modular, maintainable, and showcases effective use of polymorphism in managing bank clients and accounts.

## Project Structure
- **Main Class**: Handles the reading of the input file and processes each command line.
- **Bank Class**: Manages the bank's clients and accounts, performing actions such as adding clients and accounts, or performing transactions.
- **BankClient Class**: Represents a client of the bank, containing information like the client's name and ID.
- **BankAccount Classes**: Includes an abstract `BankAccount` class along with `ChequingAccount` and `SavingsAccount` subclasses, demonstrating the use of polymorphism.

## Features
- Efficient processing of various banking commands through text file parsing.
- Modular design for easy scalability and maintenance.
- Robust error handling through comprehensive exception management.
- Implementation of banking operations such as account creation, deposits, withdrawals, and interest calculations, leveraging polymorphism.
- Illustration of object-oriented concepts including inheritance, encapsulation, and particularly polymorphism in the design of bank account types.

## Learnings
- Developing a Java application simulating real-world banking operations.
- Designing a class hierarchy to represent different types of bank accounts, using polymorphism to handle different account behaviors.
- Employing exception handling to ensure robust error management in a banking context.


## How to Compile and Run
### Compile
From the root directory of the project, compile the Java files:

```bash
javac -d bin src/*.java
```

### Run
Execute the Main class:
```bash
java -cp bin/ Main
```

### Input File
The `command.txt` file in the project directory contains the necessary commands for simulation.

## Output Based on `command.txt`
```bash
# This is a test
# 
# This is another test
# The next line (which is empty) should just be ignored
# Final test of the comments
#
# Testing creating a client
NEW CLIENT CREATED
# Printing client info
#
# Testing creating another client
NEW CLIENT CREATED
# Printing client info
#
# Testing printing client info for a client that does not exist
#
# Testing wrong commands
# This should throw an InvalidCommandArgsException   
InvalidCommandArgsException: GET-CLIENT-INFO: First or last name or ID is missing.
# This should throw a WrongCommandException
WrongCommandException: The command WRONG is not recognized.
# This is another InvalidCommandArgsException        
InvalidCommandArgsException: NEW-CLIENT: First or last name or ID is missing.
#
# Creating a new chequing account with 0 balance for Johnny Cage
NEW ACCOUNT OF TYPE CHQ CREATED WITH ID = 500000     
# Printing account info for previously created account (id = 500000)
Chequing account id: 500000
Owner: Johnny Cage
Balance: $0.00
#
# Testing creating a chequing account for a client that does not exist
CLIENT NOT FOUND
# Testing creating an account of a type that does not exist
INVALID ACCOUNT TYPE
# Testing creating an account with an incorrect number of arguments
INVALID NUMBER OF ARGUMENTS for NEW-ACCOUNT, 5 Expected.
#
# Creating an account for Sonia Blade with 1000 balance
NEW ACCOUNT OF TYPE CHQ CREATED WITH ID = 500001     
# Printing account info for previously created account (id = 500001)
Chequing account id: 500001
Owner: Sonia Blade
Balance: $1000.00
#
# Printing account info for unexisting account       
ACCOUNT NOT FOUND
# Printing account info without enough arguments     
InvalidCommandArgsException: GET-ACCOUNT-INFO: First or last name or ID is missing.
#
# Testing withdrawal on chequing account with 0 balance: 500000 (throws InsufficientFundsException)       
Insufficient funds for the withdrawal
# Balance has not changed for this account (still 0) 
Chequing account id: 500000
Owner: Johnny Cage
Balance: $0.00
#
# Testing deposit on the chequing account 500000 (balance is now $100.00)
# Printing new state of the account 500000
Chequing account id: 500000
Owner: Johnny Cage
Balance: $100.00
#
# Testing withdrawal of 500 from account 500001 (balance was $1000)
# Printing new state of the account 500001 (balance should be $500 - transaction fees = $495.05)
Chequing account id: 500001
Owner: Sonia Blade
Balance: $495.05
# Trying to withdraw another 500 from account 500001 is now impossible
Insufficient funds for the withdrawal
# But we can withdraw 495 (the fees, but only the fees, can bring the balance below 0)
# Printing new state of the account 500001 (balance should be $0.05 - transaction fees = $-4.90)
Chequing account id: 500001
Owner: Sonia Blade
Balance: $-4.90
#
Owner: Sonia Blade
Balance: $6000.00
# Withdrawing money from the savings account does not involve transaction fees
# Printing account info now shows the new balance of $5750.00
Savings account id: 500002
Owner: Sonia Blade
Balance: $5750.00
# Deposit works as usual: depositing 750 in savings account 500002
# Printing account info now shows the new balance of $6500.00
Savings account id: 500002
Owner: Sonia Blade
Balance: $6500.00
#
# Creating a new savings account for Johnny Cage with a balance of $10
NEW ACCOUNT OF TYPE SVG CREATED WITH ID = 500003
# Printing account info for this new account (id = 500003)
Savings account id: 500003
Owner: Johnny Cage
Balance: $10.00
#
# Now using the INTEREST command, only the savings account will collect interest
INTEREST WAS PAID
# Now checking the balance of chequing account 500000 (no change to balance --> still $100.00)
Chequing account id: 500000
Owner: Johnny Cage
Balance: $100.00
# Now checking the balance of chequing account 500001 (no change to balance --> still $-4.90)
Chequing account id: 500001
Owner: Sonia Blade
Balance: $-4.90
# Now checking the balance of savings account 500002 (interest was collected --> balance is now $6597.50)
Savings account id: 500002
Owner: Sonia Blade
Balance: $6597.50
# Now checking the balance of savings account 500003 (interest was collected --> balance is now $10.15)
Savings account id: 500003
Owner: Johnny Cage
Balance: $10.15
```