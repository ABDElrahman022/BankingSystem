
package tests;

import models.Account;
import patterns.singleton.TransactionManager;

public class TestDecorator {
    public static void main(String[] args) {
        TransactionManager manager = TransactionManager.getInstance();

        // Create a basic Savings Account
        Account savingsAccount = manager.createAccount("savings");
        savingsAccount.accountDetails();

        System.out.println("\nAdding Overdraft Protection:");
        // Add Overdraft Protection
        Account overdraftAccount = manager.addFeature(savingsAccount, "overdraft");
        overdraftAccount.accountDetails();

        System.out.println("\nAdding Premium Benefits:");
        // Add Premium Benefits
        Account premiumAccount = manager.addFeature(overdraftAccount, "premium");
        premiumAccount.accountDetails();

        System.out.println("\nAdding Rewards Program:");
        // Add Rewards Program
        Account rewardsAccount = manager.addFeature(premiumAccount, "rewards");
        rewardsAccount.accountDetails();
    }
}
