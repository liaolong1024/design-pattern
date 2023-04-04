package com.java.compound.mvc.controller;

/**
 * @author LiaoLong
 * @create 2023-04-02 22:05
 */
public interface ControllerInterface {

    void start();

    void stop();

    void setBPM(int bpm);

    void increaseBPM();

    void decreaseBPM();
}
