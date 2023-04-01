package com.java.state.state;

import com.java.state.CandyMachine;
import com.java.state.CandyMachineNew;

/**
 * @author ll
 */
public class SoldOutState implements State{

    CandyMachineNew machine;

    public SoldOutState(CandyMachineNew candyMachineNew) {
        this.machine = candyMachineNew;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
