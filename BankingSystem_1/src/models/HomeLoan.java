package models;

public class HomeLoan implements Loan {
    @Override
    public void loanDetails() {
        System.out.println("Home Loan created with long-term repayment plan.");
    }
}
