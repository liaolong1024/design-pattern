package com.java.observer.observer;

import com.java.observer.subject.Subject;

/**
 * @author ll
 */
public class CurrentConditionsObserver implements Observer, DisplayElement{

    private float temp;
    private float humidity;
    private Subject subject;

    public CurrentConditionsObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current: " + temp + " " + humidity);
    }
}
