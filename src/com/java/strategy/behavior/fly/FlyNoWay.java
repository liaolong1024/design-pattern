package com.java.strategy.behavior.fly;

/**
 * @author ll
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
