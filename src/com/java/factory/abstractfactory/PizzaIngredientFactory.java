package com.java.factory.abstractfactory;

import com.java.factory.abstractfactory.ingredient.Dough;
import com.java.factory.abstractfactory.ingredient.Sauce;

/**
 * 根据需要创建实现PizzaIngredientFactory接口的子类
 *
 * @author ll
 */
public interface PizzaIngredientFactory {

    // 单独来讲createDough就是一个工厂方法
    Dough createDough();

    // createSauce也是一个工厂方法
    Sauce createSauce();
}
