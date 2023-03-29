package com.java.decorator.beverage;

/**
 * 饮料的超类
 *
 * @author ll
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
