package com.java.adapter;

import com.java.adapter.adapter.TurkeyAdapter;
import com.java.adapter.duck.Duck;
import com.java.adapter.turkey.WildTurkey;

/**
 * @author ll
 */
public class Test {
    public static void main(String[] args) {
        Duck turkeyAdapter = new TurkeyAdapter(new WildTurkey());
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}

