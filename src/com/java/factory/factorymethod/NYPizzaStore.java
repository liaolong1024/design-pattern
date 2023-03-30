package com.java.factory.factorymethod;

import com.java.factory.pizza.Pizza;

/**
 * @author ll
 */
public class NYPizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        }
        return pizza;
    }
}
