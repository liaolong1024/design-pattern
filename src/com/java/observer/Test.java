package com.java.observer;

import com.java.observer.observer.CurrentConditionsObserver;
import com.java.observer.subject.WeatherDataSubject;

/**
 * @author ll
 */
public class Test {
    public static void main(String[] args) {
        WeatherDataSubject subject = new WeatherDataSubject();
        CurrentConditionsObserver currentConditionsObserver = new CurrentConditionsObserver(subject);
        subject.setMeasurements(1.0f, 2.0f, 3.0f);
    }
}
