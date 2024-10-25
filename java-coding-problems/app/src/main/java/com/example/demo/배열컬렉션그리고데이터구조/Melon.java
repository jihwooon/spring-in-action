package com.example.demo.배열컬렉션그리고데이터구조;

public record Melon(
    String type,
    int weight
) {

    public int getWeight() {
        return weight;
    }
}
