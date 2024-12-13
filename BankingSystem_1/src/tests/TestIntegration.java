package tests;

import models.Account;
import models.Loan;
import patterns.singleton.TransactionManager;

public class TestIntegration {
    public static void main(String[] args) {
        // Get the single instance of TransactionManager
        TransactionManager manager = TransactionManager.getInstance();

        // Create accounts using the TransactionManager
        Account savings = manager.createAccount("savings");
        savings.accountDetails();

        Account checking = manager.createAccount("checking");
        checking.accountDetails();

        // Create loans using the TransactionManager
        Loan homeLoan = manager.createLoan("home");
        homeLoan.loanDetails();

        Loan personalLoan = manager.createLoan("personal");
        personalLoan.loanDetails();

        // Process a transaction
        manager.processTransaction("12345", 500.0, "Deposit");
    }
}
