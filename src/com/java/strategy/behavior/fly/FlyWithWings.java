package com.java.strategy.behavior.fly;

/**
 * @author ll
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly With Wings");
    }
}
