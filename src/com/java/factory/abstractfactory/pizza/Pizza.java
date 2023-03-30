package com.java.factory.abstractfactory.pizza;

import com.java.factory.abstractfactory.ingredient.Dough;
import com.java.factory.abstractfactory.ingredient.Sauce;

/**
 * @author ll
 */
public abstract class Pizza {
    Dough dough;
    Sauce sauce;
    /** 该方法用来收集制作Pizza需要的原料 */
    abstract void prepare();
}
