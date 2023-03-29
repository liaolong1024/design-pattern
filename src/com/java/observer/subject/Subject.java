package com.java.observer.subject;

import com.java.observer.observer.Observer;

/**
 * @author LiaoLong
 * @create 2023-03-29 17:42
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
