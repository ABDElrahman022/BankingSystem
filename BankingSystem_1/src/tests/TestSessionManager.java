package tests;

import patterns.singleton.SessionManager;

public class TestSessionManager {
    public static void main(String[] args) {
        SessionManager session1 = SessionManager.getInstance();
        SessionManager session2 = SessionManager.getInstance();

        session1.login("admin");

        if (session1 == session2) {
            System.out.println("SessionManager is a Singleton!");
            System.out.println("Current User: " + session2.getCurrentUser());
        }

        session2.logout();
    }
}
