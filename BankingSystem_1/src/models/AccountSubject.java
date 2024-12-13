package models;

import patterns.observer.Observer;
import patterns.observer.Subject;
import java.util.ArrayList;
import java.util.List;

public class AccountSubject implements Subject {
    private final List<Observer> observers;
    private final String accountNumber;
    private final boolean isJointAccount; 

    public AccountSubject(String accountNumber, boolean isJointAccount) {
        this.accountNumber = accountNumber;
        this.isJointAccount = isJointAccount; 
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        if (!isJointAccount && observers.size() >= 1) {
            throw new IllegalStateException("Cannot add multiple observers to a non-joint account.");
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update("Account " + accountNumber + ": " + message);
        }
    }

    public void performTransaction(String type, double amount) {
        String transactionMessage = type + " of $" + amount + " was processed.";
        System.out.println(transactionMessage);
        notifyObservers(transactionMessage);
    }
}
