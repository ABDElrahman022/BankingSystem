package tests;

import models.Loan;
import patterns.factory.LoanFactory;

public class TestLoanFactory {
    public static void main(String[] args) {
        Loan homeLoan = LoanFactory.createLoan("home");
        homeLoan.loanDetails();

        Loan personalLoan = LoanFactory.createLoan("personal");
        personalLoan.loanDetails();

        Loan carLoan = LoanFactory.createLoan("car");
        carLoan.loanDetails();
    }
}
