package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {

    private final List<Action> actions;

    public BusinessRuleEngine() {
        this.actions = new ArrayList<>();
    }

    public void addAction(final Action action) {
        actions.add(action);
    }

    public int count() {
        return actions.size();
    }

    public void run() {
        actions.forEach(Action::execute);
    }
}
