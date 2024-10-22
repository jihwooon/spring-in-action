package com.example.demo.함수형디자인패턴.전략패턴;

@FunctionalInterface
public interface RemoveStrategy {

    String execute(String s);
}
