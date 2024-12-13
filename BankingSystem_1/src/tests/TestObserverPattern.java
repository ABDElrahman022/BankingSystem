package tests;

import models.AccountHolder;
import models.AccountSubject;

public class TestObserverPattern {
    public static void main(String[] args) {
        // Create a non-joint account (single observer allowed)
        AccountSubject singleAccount = new AccountSubject("12345", false);
        AccountHolder alice = new AccountHolder("Alice");
        singleAccount.addObserver(alice);

        // Perform a transaction
        singleAccount.performTransaction("Deposit", 500.0);

        // Trying to add another observer should throw an exception
        try {
            AccountHolder bob = new AccountHolder("Bob");
            singleAccount.addObserver(bob); // This will fail
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Create a joint account (multiple observers allowed)
        AccountSubject jointAccount = new AccountSubject("67890", true);
        AccountHolder charlie = new AccountHolder("Charlie");
        AccountHolder dave = new AccountHolder("Dave");

        jointAccount.addObserver(charlie);
        jointAccount.addObserver(dave);

        // Perform a transaction
        jointAccount.performTransaction("Withdrawal", 200.0);
    }
}
