package com.java.compound;

import com.java.compound.duck.Quackable;

/**
 * 装饰者, 增加行为,  记录quack次数
 *
 * @author ll
 */
public class QuackCounter implements Quackable {

    Quackable duck;

    static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }
}
