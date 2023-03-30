package com.java.factory;

import com.java.factory.pizza.Pizza;
import com.java.factory.simplefactory.SimplePizzaFactory;

/**
 * @author ll
 */
public class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);

        return pizza;
    }
}
