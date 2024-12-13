# Banking System GUI Application

## Overview

This project is a **Banking System GUI Application** developed using **Java Swing**. The main goal is to showcase the implementation of design patterns like **Singleton**, **Factory**, **Observer**, **Strategy**, and **Decorator** in a practical, real-world banking scenario. The application allows users to manage bank accounts, loans, and transactions through an intuitive graphical interface.

## Features

### Account Management:
- Create **Savings** or **Checking** accounts.
- Dynamically view account details.

### Loan Management:
- Create **Home**, **Personal**, or **Car** loans.
- Dynamically view loan details.

### Transaction Management:
- Deposit and withdraw money.
- Log and display all transactions.

### Action Logging:
- Logs all user actions and displays them in a table.
- Logs update dynamically after each action.

## Design Patterns Used

- **Singleton Pattern:**
  - **TransactionManager**: Ensures only one instance handles all transactions.
  - **SessionManager**: Manages user sessions consistently.

- **Factory Pattern:**
  - **AccountFactory**: Creates Savings or Checking accounts.
  - **LoanFactory**: Creates Home, Personal, or Car loans.

- **Observer Pattern:**
  - Notifies observers of updates in account transactions.

- **Strategy Pattern:**
  - Defines interest calculation strategies for different account types.

- **Decorator Pattern:**
  - **AccountDecorator**: Adds additional responsibilities to accounts without modifying the original class, such as adding overdraft protection or premium features to basic accounts.

## Prerequisites

- **Java Development Kit (JDK):** Version 8 or later.
- **IDE:** IntelliJ IDEA, Eclipse, or any preferred Java IDE.

## How to Run the Application

1. Clone the repository to your local machine:
    ```bash
    git clone https://github.com/ABDElrahman022/BankingSystem
    ```
2. Open the project in your Java IDE.
3. Compile and run the `BankGUI` class located in the `gui` package.
4. Interact with the GUI to manage accounts, loans, and transactions.

## Usage

### GUI Layout

- **Main Table**: Displays a log of all actions performed.
- **Input Fields**: Enter details like account type, loan type, account number, and transaction amount.
- **Buttons:**
  - **Create Account**: Creates an account based on the entered type.
  - **Create Loan**: Creates a loan based on the entered type.
  - **Deposit**: Deposits the entered amount into the specified account.
  - **Withdraw**: Withdraws the entered amount from the specified account.

### Error Handling

- Error messages for invalid inputs are displayed using `JOptionPane` dialogs.

## Code Structure
![BankingSystem UML ](https://github.com/user-attachments/assets/00e0212b-fa13-43ed-913d-51ea11c4cf2a)

### Key Classes

- **BankGUI**: The entry point for the application. It manages the graphical user interface and user interactions.
- **TransactionManager (Singleton)**: Handles all transactions centrally.
- **AccountFactory & LoanFactory**: Responsible for creating account and loan objects.
- **ActionLogger (Singleton)**: Logs and retrieves user actions.
- **AccountDecorator**: Enhances basic accounts with additional features using the Decorator pattern.

### Packages

- **gui**: Contains the GUI implementation.
- **models**: Defines core models such as Account, Loan, and ActionLogger.
- **patterns.factory**: Implements the Factory pattern.
- **patterns.singleton**: Implements the Singleton pattern.
- **patterns.observer**: Implements the Observer pattern.
- **patterns.strategy**: Implements the Strategy pattern for interest calculation.
- **patterns.decorator**: Implements the Decorator pattern for enhancing account functionalities.

## Future Enhancements

- Add **user authentication** and session management in the GUI.
- Provide detailed **account** and **loan summaries**.
- Include **interest calculations** and display them in transaction logs.
- Integrate with a **database** to persist account and transaction data.

## License

This project is licensed under the **MIT License**. See the LICENSE file for more details.
