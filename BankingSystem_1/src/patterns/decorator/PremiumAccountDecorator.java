
package patterns.decorator;

import models.Account;

public class PremiumAccountDecorator extends AccountDecorator {
    public PremiumAccountDecorator(Account decoratedAccount) {
        super(decoratedAccount);
    }

    @Override
    public void accountDetails() {
        super.accountDetails();
        System.out.println("Premium Account with additional benefits.");
    }
}
