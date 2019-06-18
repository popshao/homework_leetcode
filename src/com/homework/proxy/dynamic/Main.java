package com.homework.proxy.dynamic;

import java.lang.reflect.Proxy;

import com.homework.proxy.statics.BaseMethod;
import com.homework.proxy.statics.RealMethod;

/**
 * 动态代理
 * 
 * @Author: lei.zhang
 * @Email: lei.zhang@rograndec.com
 * @CreateDate: 2019/2/19
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        BaseMethod proxyBaseMethod = (BaseMethod)Proxy.newProxyInstance(BaseMethod.class.getClassLoader(), new Class[] {BaseMethod.class}, new BasicDynamicMethod(new RealMethod()) {
            
            @Override   
            public Object doSomethingBefore(Object[] args) {
                System.out.println("do something before...");
                return null;
            }
            
            @Override
            public Object doSomethingAfter(Object[] args) {
                System.out.println("do something after...");
                return null;
            }
        });
        
        proxyBaseMethod.action();
    
    }
}
