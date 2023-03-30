package com.java.factory.factorymethod;

import com.java.factory.pizza.Pizza;

/**
 * @author ll
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        return pizza;
    }

    /** 该方法为工厂方法，由子类提供创建Pizza对象的方法 */
    abstract Pizza createPizza(String type);
}
