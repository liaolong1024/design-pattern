package com.java.state.state;

import com.java.state.CandyMachine;
import com.java.state.CandyMachineNew;

/**
 * @author ll
 */
public class NoQuarterState implements State{

    CandyMachineNew machine;


    public NoQuarterState(CandyMachineNew machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        machine.setState(machine.getHasQuarter());
    }

    @Override
    public void ejectQuarter() {
        // 拒绝逻辑
        System.out.println("...");
    }

    @Override
    public void turnCrank() {
        // 拒绝逻辑
        System.out.println("...");
    }

    @Override
    public void dispense() {
        // 拒绝逻辑
        System.out.println("...");
    }
}
