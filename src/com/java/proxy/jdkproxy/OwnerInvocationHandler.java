package com.java.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ll
 */
public class OwnerInvocationHandler implements InvocationHandler {

    PersonBean personBean;

    public OwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(personBean, args);
    }
}
