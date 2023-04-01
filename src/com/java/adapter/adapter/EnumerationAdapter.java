package com.java.adapter.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author ll
 */
public class EnumerationAdapter<T> implements Iterator<T> {

    Enumeration<T> enumeration;

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

}
