package com.example.demo.함수형디자인패턴.전략패턴;

public class NumberRemove implements RemoveStrategy {

    @Override
    public String execute(String s) {
        return s.replaceAll("\\d", "");
    }
}
