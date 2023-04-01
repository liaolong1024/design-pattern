package com.java.state.state;

import com.java.state.CandyMachineNew;

/**
 * @author ll
 */
public class SoldState implements State{

    CandyMachineNew machineNew;

    public SoldState(CandyMachineNew candyMachineNew) {
        this.machineNew = candyMachineNew;
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
