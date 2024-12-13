package patterns.singleton;

import models.Account;
import models.Loan;
import models.ActionLogger;
import patterns.factory.AccountFactory;
import patterns.factory.LoanFactory;
import patterns.decorator.*;

public class TransactionManager {
    private static TransactionManager instance;
    private final ActionLogger logger;
    
    // Private constructor to restrict instantiation
    private TransactionManager() {
        logger = ActionLogger.getInstance();
        System.out.println("Transaction Manager initialized.");
    }

    // Public method to provide access to the instance
    public static TransactionManager getInstance() {
        if (instance == null) {
            instance = new TransactionManager();
        }
        return instance;
    }

    // Method to create and manage accounts
    public Account createAccount(String accountType) {
        Account account = AccountFactory.createAccount(accountType);
        logger.log("Created " + accountType + " account.");
        System.out.println("Account created using Transaction Manager.");
        return account;
    }

    public Account addFeature(Account account, String feature) {
        switch (feature.toLowerCase()) {
            case "overdraft" -> {
                return new OverdraftAccountDecorator(account);
            }
            case "premium" -> {
                return new PremiumAccountDecorator(account);
            }
            case "rewards" -> {
                return new RewardsAccountDecorator(account);
            }
            default -> throw new IllegalArgumentException("Invalid feature: " + feature);
        }
    }
    // Method to create and manage loans
    public Loan createLoan(String loanType) {
        Loan loan = LoanFactory.createLoan(loanType);
        logger.log("Created " + loanType + " loan.");
        System.out.println("Loan created using Transaction Manager.");
        return loan;
    }

    // Method to process a transaction
    public void processTransaction(String accountNumber, double amount, String type) {
        String transactionDetails = type + " of $" + amount + " for account " + accountNumber;
        logger.log(transactionDetails);
        System.out.println(transactionDetails);
    }  
}
