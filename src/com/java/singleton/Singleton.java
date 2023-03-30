package com.java.singleton;

/**
 * @author ll
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) { // 如果没有禁止重排序，其他线程执行到这一步，这里可能会判断为true(即new Singleton的第三步先于第二步执行)，此时返回的是一个未完全初始化的对象
            synchronized (Singleton.class) {
                if (instance == null) {
                    /*
                      volatile防止以下顺序重排序
                       1. 分配内存空间
                       2. 在内存空间中初始化对象
                       3. 将内存地址赋值给instance
                     */
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
