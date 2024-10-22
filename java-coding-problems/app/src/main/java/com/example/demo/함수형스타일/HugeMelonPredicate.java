package com.example.demo.함수형스타일;

public class HugeMelonPredicate implements MelonPredicate {

    @Override
    public boolean calculate(Melon melon) {
        return melon.getWeight() > 5000;
    }
}
