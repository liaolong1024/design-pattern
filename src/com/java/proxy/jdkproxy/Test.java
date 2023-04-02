package com.java.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author ll
 */
public class Test {
    public static void main(String[] args) {
        PersonBean personBean = new PersonBeanImpl();
        PersonBean proxy = (PersonBean)Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnerInvocationHandler(personBean)
        );
        System.out.println(proxy.getName());
        System.out.println(Proxy.isProxyClass(proxy.getClass()));
    }
}
