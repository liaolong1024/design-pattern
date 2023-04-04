package com.java.compound;

import com.java.compound.duck.MallardDuck;
import com.java.compound.duck.Quackable;

/**
 * @author ll
 */
public class CountingDuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }
}
