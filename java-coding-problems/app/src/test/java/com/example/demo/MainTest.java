package com.example.demo;

import com.example.demo.함수형디자인패턴.템플릿메서드패턴.GreekPizza;
import com.example.demo.함수형디자인패턴.템플릿메서드패턴.Main;
import com.example.demo.함수형디자인패턴.템플릿메서드패턴.NeapolitanPizza;
import com.example.demo.함수형디자인패턴.템플릿메서드패턴.Pizza;
import com.example.demo.함수형디자인패턴.템플릿메서드패턴.PizzaLambda;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testMakePizza() {
        Main main = new Main();

        main.makePizza(new NeapolitanPizza(), new Pizza());
        main.makePizza(new GreekPizza(), new Pizza());

        PizzaLambda pizzaLambda = new PizzaLambda();
        pizzaLambda.make(new Pizza(), (Pizza p) -> System.out.println(
                "Add: bits of tomato, onion, anchovies, and herbs"));
    }
}
