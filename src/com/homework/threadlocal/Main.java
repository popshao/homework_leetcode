package com.homework.threadlocal;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Target target = new Target();
        Thread t1 = new Thread(target);
        t1.start();
        t1.join();
        Thread t2 = new Thread(target);
        target.flag = true;
        t2.start();
        
    }
}
