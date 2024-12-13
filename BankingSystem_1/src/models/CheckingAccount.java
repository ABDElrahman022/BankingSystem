package models;

public class CheckingAccount implements Account {
    @Override
    public void accountDetails() {
        System.out.println("Checking Account created with overdraft protection.");
    }
}