package models;

public class PersonalLoan implements Loan {
    @Override
    public void loanDetails() {
        System.out.println("Personal Loan created with flexible repayment options.");
    }
}
