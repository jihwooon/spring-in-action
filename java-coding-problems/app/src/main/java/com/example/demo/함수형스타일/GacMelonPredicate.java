package com.example.demo.함수형스타일;

public class GacMelonPredicate implements MelonPredicate {

    @Override
    public boolean calculate(Melon melon) {
        return "gac".equalsIgnoreCase(melon.getType());
    }
}
