package com.java.decorator;

import com.java.decorator.beverage.Beverage;
import com.java.decorator.beverage.Espresso;
import com.java.decorator.beveragedecorator.Mocha;

/**
 * @author ll
 */
public class Test {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "  " + beverage.cost());

        Beverage beverage2 = new Espresso();
        Mocha mocha = new Mocha(beverage2);
        System.out.println(mocha.getDescription() + "  " + mocha.cost());
    }
}
