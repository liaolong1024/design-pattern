package com.java.singleton;

/**
 * @author ll
 */
public class EnumBasedSingletonExample {

    // 与内部类相似, 初次访问时才会被初始化
    public static enum Singleton {
        INSTANCE;
        Singleton() {
        }
    }
}
