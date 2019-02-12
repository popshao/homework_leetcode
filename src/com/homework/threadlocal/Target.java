package com.homework.threadlocal;

public class Target implements Runnable {

    public static Boolean flag = false;
    
    public static ThreadLocal<Person> personTH = new ThreadLocal<>();
    
    @Override
    public void run() {
        personTH.set(new Person("张三"));
        if (flag) {
            personTH.get().setName("李四");
        }
        //ThreadLocal<Person> personTL = new ThreadLocal<>();
        System.out.println(personTH.get().getName());
    }

}
