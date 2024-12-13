
package patterns.decorator;

import models.Account;

public abstract class AccountDecorator implements Account {
    protected Account decoratedAccount;

    public AccountDecorator(Account decoratedAccount) {
        this.decoratedAccount = decoratedAccount;
    }

    @Override
    public void accountDetails() {
        decoratedAccount.accountDetails();
    }
}

