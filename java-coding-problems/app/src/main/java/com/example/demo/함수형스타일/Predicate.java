package com.example.demo.함수형스타일;

@FunctionalInterface
public interface Predicate<T> {

    boolean calculate(T t);
}
