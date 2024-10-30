package com.example.demo.객체와불변성;

public record Car(String name, String color) {

    public Car {
        if (name == null && color == null) {
            throw new NullPointerException("Both name, color cannot be null");
        }

        if (name == null) {
            throw new NullPointerException("Car name cannot be null");
        }
        if (color == null) {
            throw new NullPointerException("Car color cannot be null");
        }

    }

    public void assignDriver(String license, String location) {
        if (license == null) {
            throw new NullPointerException("License cannot be null");
        }
        if (location == null) {
            throw new NullPointerException("Location cannot be null");
        }
    }
}
