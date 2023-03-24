package com.java.strategy.behavior.quack;

/**
 * @author ll
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("quack");
    }
}
