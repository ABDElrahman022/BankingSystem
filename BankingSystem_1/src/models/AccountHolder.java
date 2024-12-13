package models;

import patterns.observer.Observer;

public class AccountHolder implements Observer {
    private final String name;

    public AccountHolder(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}
