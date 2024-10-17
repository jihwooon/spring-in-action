package com.example.demo.함수형디자인패턴.템플릿메서드패턴;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void result() {
        Main main = new Main();

        main.makePizza(new NeapolitanPizza(), new Pizza());
        main.makePizza(new GreekPizza(), new Pizza());

        PizzaLambda pizzaLambda = new PizzaLambda();
        pizzaLambda.make(new Pizza(), (Pizza p) -> System.out.println(
                "Add: bits of tomato, onion, anchovies, and herbs"));
    }
}
