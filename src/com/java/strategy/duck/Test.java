package com.java.strategy.duck;

import com.java.strategy.behavior.quack.MuteQuack;

/**
 * @author ll
 */
public class Test {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.performFly();

        mallardDuck.performQuack();
        mallardDuck.setQuackBehavior(new MuteQuack());
        mallardDuck.performQuack();
    }
}
