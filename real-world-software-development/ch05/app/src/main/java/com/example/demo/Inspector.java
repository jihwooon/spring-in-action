package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inspector {

    private final List<ConditionalAction> conditionalActionList;

    public Inspector(ConditionalAction... conditionalAction) {
        this.conditionalActionList = Arrays.asList(conditionalAction);
    }

    public List<Report> inspect(final Facts facts) {
        final ArrayList<Report> reports = new ArrayList<>();
        for (ConditionalAction conditionalAction : conditionalActionList) {
            final boolean conditionResult = conditionalAction.evaluate(facts);
            reports.add(new Report(conditionalAction, facts, conditionResult));
        }

        return reports;
    }

}
