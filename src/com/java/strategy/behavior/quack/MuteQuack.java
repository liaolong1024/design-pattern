package com.java.strategy.behavior.quack;

/**
 * @author ll
 */
public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
