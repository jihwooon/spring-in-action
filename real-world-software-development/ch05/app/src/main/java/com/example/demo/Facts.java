package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Facts {

    private final Map<String, String> facts = new HashMap<>();

    public String getFacts(final String name) {
        return facts.get(name);
    }

    public void addFact(final String name, final String value) {
        facts.put(name, value);
    }
}
