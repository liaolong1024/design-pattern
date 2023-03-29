package com.java.proxy;

/**
 * @author ll
 */
public class GumballMachineMonitor {

    GumballMachine machine;

    public GumballMachineMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        System.out.println(machine.getLocation());
    }
}
