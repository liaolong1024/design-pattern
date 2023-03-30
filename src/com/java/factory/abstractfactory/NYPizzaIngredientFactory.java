package com.java.factory.abstractfactory;

import com.java.factory.abstractfactory.ingredient.Dough;
import com.java.factory.abstractfactory.ingredient.MarinaraSauce;
import com.java.factory.abstractfactory.ingredient.Sauce;
import com.java.factory.abstractfactory.ingredient.ThinCrustDough;

/**
 * @author ll
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }
}
