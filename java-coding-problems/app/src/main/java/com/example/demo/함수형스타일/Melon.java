package com.example.demo.함수형스타일;

import java.util.ArrayList;
import java.util.List;

public class Melon {

    private final String type;
    private final int weight;
    private final String origin;

    public Melon(String type, int weight, String origin) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }
}
