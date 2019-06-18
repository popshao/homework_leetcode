package com.homework.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class BasicDynamicMethod implements InvocationHandler {

    private Object object;
    
    public BasicDynamicMethod(Object obj) {
        this.object = obj;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBefore(args);
        Object result = method.invoke(object, args);
        doSomethingAfter(args);
        return result;
    }

    public abstract Object doSomethingBefore(Object[] args);
    
    public abstract Object doSomethingAfter(Object[] args);
    
}
