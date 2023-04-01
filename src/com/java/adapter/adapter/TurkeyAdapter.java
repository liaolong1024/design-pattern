package com.java.adapter.adapter;

import com.java.adapter.duck.Duck;
import com.java.adapter.turkey.Turkey;

/**
 * 将Turkey转换为Duck
 *
 * @author ll
 */
public class TurkeyAdapter implements Duck {

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
