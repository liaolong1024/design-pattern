package com.java.proxy;

/**
 * @author ll
 */
public class GumballMachine {

    String location;

    public GumballMachine(String location, int count) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
