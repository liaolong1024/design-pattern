package com.java.compound.mvc.model;

/**
 * 节拍模型, 包含观察者模式
 * @author ll
 */
public interface BeatModelInterface {

    // 控制器可调用的方法
    void initialize();
    void on();
    void off();
    void setBPM(int bpm);
    int getBPM();

    // 观察者模式方法
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);

}
