package com.java.factory.simplefactory;

import com.java.factory.pizza.CheesePizza;
import com.java.factory.pizza.PepperoniPizza;
import com.java.factory.pizza.Pizza;
import com.java.factory.pizza.VeggiePizza;

/**
 * @author ll
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
