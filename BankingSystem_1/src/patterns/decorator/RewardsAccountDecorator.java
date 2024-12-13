
package patterns.decorator;

import models.Account;

public class RewardsAccountDecorator extends AccountDecorator {
    public RewardsAccountDecorator(Account decoratedAccount) {
        super(decoratedAccount);
    }

    @Override
    public void accountDetails() {
        super.accountDetails();
        System.out.println("Rewards program added to the account.");
    }
}