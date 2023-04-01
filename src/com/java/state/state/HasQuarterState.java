package com.java.state.state;

import com.java.state.CandyMachineNew;

/**
 * @author ll
 */
public class HasQuarterState implements State{

    CandyMachineNew machineNew;

    public HasQuarterState(CandyMachineNew machineNew) {
        this.machineNew = machineNew;
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
