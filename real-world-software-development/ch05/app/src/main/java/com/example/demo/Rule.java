package com.example.demo;

@FunctionalInterface
public interface Rule {

    void perform(Facts facts);
}
