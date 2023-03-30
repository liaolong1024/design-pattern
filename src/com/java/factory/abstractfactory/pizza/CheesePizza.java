package com.java.factory.abstractfactory.pizza;

import com.java.factory.abstractfactory.PizzaIngredientFactory;

/**
 * @author ll
 */
public class CheesePizza extends Pizza{

    PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
    }
}
