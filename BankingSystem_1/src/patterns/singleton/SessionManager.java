package patterns.singleton;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static SessionManager instance;
    private String currentUser;
    private Map<String, String> users = new HashMap<>();
    // Private constructor to restrict instantiation
    private SessionManager() {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("admin", "admin123");
    }

    // Public method to provide access to the instance
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Methods to manage session
    public void login(String username) {
        this.currentUser = username;
        System.out.println("User " + username + " logged in.");
    }
    
    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            return true;  
        }
        return false;  
    }
    public void logout() {
        System.out.println("User " + currentUser + " logged out.");
        this.currentUser = null;
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
