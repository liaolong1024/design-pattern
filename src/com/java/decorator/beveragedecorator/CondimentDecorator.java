package com.java.decorator.beveragedecorator;

import com.java.decorator.beverage.Beverage;

/**
 * 装饰者超类， 注意要继承饮料超类
 * @author ll
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
