package models;

public class CarLoan implements Loan {
    @Override
    public void loanDetails() {
        System.out.println("Car Loan created with competitive interest rates.");
    }
}
