package models;

public class SavingsAccount implements Account {
    @Override
    public void accountDetails() {
        System.out.println("Savings Account created with standard interest rates.");
    }
}
