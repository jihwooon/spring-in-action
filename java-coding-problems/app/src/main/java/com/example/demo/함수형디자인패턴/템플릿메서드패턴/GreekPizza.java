package com.example.demo.함수형디자인패턴.템플릿메서드패턴;

public class GreekPizza extends PizzaMaker {

    @Override
    public void addToIngredients(Pizza pizza) {
        System.out.println("Add:  sauce and cheese");
    }
}
