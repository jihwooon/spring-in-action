package com.example.demo.함수형디자인패턴.템플릿메서드패턴;

public abstract class PizzaMaker {

    public void make(Pizza pizza) {
        makeDough(pizza);
        addToIngredients(pizza);
        bake(pizza);
    }

    private void makeDough(Pizza pizza) {
        System.out.println("Make dough");
    }

    private void bake(Pizza pizza) {
        System.out.println("Bake the pizza");
    }

    public abstract void addToIngredients(Pizza pizza);

}
