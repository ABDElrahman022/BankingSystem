package tests;

import models.Account;
import patterns.factory.AccountFactory;

public class TestAccountFactory {
    public static void main(String[] args) {
        Account savings = AccountFactory.createAccount("savings");
        savings.accountDetails();

        Account checking = AccountFactory.createAccount("checking");
        checking.accountDetails();
    }
}
