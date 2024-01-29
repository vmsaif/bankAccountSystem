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
