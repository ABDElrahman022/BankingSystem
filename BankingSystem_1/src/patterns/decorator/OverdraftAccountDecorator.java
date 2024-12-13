
package patterns.decorator;

import models.Account;

public class OverdraftAccountDecorator extends AccountDecorator {
    public OverdraftAccountDecorator(Account decoratedAccount) {
        super(decoratedAccount);
    }

    @Override
    public void accountDetails() {
        super.accountDetails();
        System.out.println("Overdraft Protection enabled.");
    }
}