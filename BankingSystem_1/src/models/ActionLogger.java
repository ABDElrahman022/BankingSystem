package models;

import java.util.ArrayList;
import java.util.List;

public class ActionLogger {
    private static ActionLogger instance;
    private final List<String> actions;

    private ActionLogger() {
        actions = new ArrayList<>();
    }

    public static ActionLogger getInstance() {
        if (instance == null) {
            instance = new ActionLogger();
        }
        return instance;
    }

    public void log(String action) {
        actions.add(action);
        System.out.println("Logged action: " + action);
    }

    public List<String> getActions() {
        return new ArrayList<>(actions);
    }
}
