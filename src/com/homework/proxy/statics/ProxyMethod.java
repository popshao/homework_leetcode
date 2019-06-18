package com.homework.proxy.statics;

public class ProxyMethod implements BaseMethod {

    @Override
    public void action() {
        RealMethod realMethod = new RealMethod();
        realMethod.action();
        
        // do the other thing
        System.out.println("do the other thing...");
    }

}
