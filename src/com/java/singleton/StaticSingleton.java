package com.java.singleton;

/**
 * 静态内部类实现单例模式
 * @author ll
 */
public class StaticSingleton {



    private StaticSingleton() {
    }

    // 初次访问时该静态类才会被初始化
    private static class InstanceHolder {
        final static StaticSingleton INSTANCE = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
