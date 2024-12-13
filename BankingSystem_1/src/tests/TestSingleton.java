package tests;

import patterns.singleton.TransactionManager;

public class TestSingleton {
    public static void main(String[] args) {
        TransactionManager tm1 = TransactionManager.getInstance();
        TransactionManager tm2 = TransactionManager.getInstance();

        tm1.processTransaction("12345", 1000, "Deposit");

        // Verify both instances are the same
        if (tm1 == tm2) {
            System.out.println("TransactionManager is a Singleton!");
        } else {
            System.out.println("TransactionManager is NOT a Singleton!");
        }
    }
}
