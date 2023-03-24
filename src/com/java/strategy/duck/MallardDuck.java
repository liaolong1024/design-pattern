package com.java.strategy.duck;

import com.java.strategy.behavior.fly.FlyWithWings;
import com.java.strategy.behavior.quack.Quack;
import com.java.strategy.duck.Duck;

/**
 * @author ll
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
