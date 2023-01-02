# Bank Account System

This is a Java program that reads and processes instructions from a text file to simulate a bank. The program is designed to be modular and maintainable, following object-oriented design principles such as encapsulation and separation of concerns.

The program consists of three main classes: the Main class, the Bank class, and the BankClient class. The Main class is responsible for reading the input file and processing each line as a command. The Bank class keeps track of the bank's clients and accounts, and handles requests from the Main class to perform various actions such as adding clients and accounts, or performing transactions. The BankClient class represents a client of the bank, and includes information such as the client's name and id, as well as methods for getting and setting this information.

## What I have learned

- Building a program that reads and processes instructions from a text file in Java.
- Implementing a set of related classes of objects, including a Main class, a Bank class, and a BankClient class.
- Designing a program using object-oriented principles, such as keeping methods short and simple, distributing work among many small methods, and making instance variables private and methods public.
- Reading a file line by line and processing each line as a command in the Main class.
- Parsing a command and determining its type in the Main class.
- Handling different types of commands, such as comment commands, in the Main class.
- Implementing the Bank class and its methods, such as those for adding and removing clients and accounts, and for performing transactions.
- Implementing the BankClient class and its methods, such as those for getting and setting the client's name and address.
- Testing code using sample input files and thinking of additional test cases.

# How to Run
## Compile
From the root directory of the repository, from terminal

    javac -d bin src\*.java

## Run

    java -cp bin\ Main

In the project directory, there is a sample command file command.txt which has all the command to be parsed. 