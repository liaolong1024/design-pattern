package com.java.state.state;

/**
 * @author LiaoLong
 * @create 2023-04-01 17:41
 */
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
