package patterns.factory;

import models.Account;
import models.SavingsAccount;
import models.CheckingAccount;

public class AccountFactory {
    public static Account createAccount(String type) {
        switch (type.toLowerCase()) {
            case "savings" -> {
                return new SavingsAccount();
            }
            case "checking" -> {
                return new CheckingAccount();
            }
            default -> throw new IllegalArgumentException("Invalid account type: " + type);
        }
    }
}
