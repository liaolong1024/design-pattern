package com.java.compound;

import com.java.compound.duck.Quackable;
import com.java.compound.goose.Goose;

/**
 * @author ll
 */
public class GooseAdapter implements Quackable {

    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
