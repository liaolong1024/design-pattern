package com.java.observer.subject;

import com.java.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ll
 */
public class WeatherDataSubject implements Subject {

    private List<Observer>  observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherDataSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(temp, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
