package com.example.demo.함수형디자인패턴.전략패턴;

public final class Remover {

    private Remover() {
        throw new AssertionError("");
    }

    public static String remove(String s, RemoveStrategy strategy) {
        return strategy.execute(s);
    }

}
