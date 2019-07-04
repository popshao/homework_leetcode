package com.homework.thread;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
    }
    public Main() {
        Thread threadA = new ThreadTest();
        threadA.run(); // 直接执行没有使用线程
        threadA.start(); // 开启了线程

        // 实现接口比继承接口好，因为继承技能继承一个，但是实现可以实现多个
        Thread threadB = new Thread(new RunnableTest());
        threadB.start();
        
    }
}
