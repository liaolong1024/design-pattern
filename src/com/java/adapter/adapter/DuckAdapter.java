package com.java.adapter.adapter;

import com.java.adapter.duck.Duck;
import com.java.adapter.turkey.Turkey;

/**
 * 将Duck转换为Turkey
 * @author ll
 */
public class DuckAdapter implements Turkey {

    Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}
