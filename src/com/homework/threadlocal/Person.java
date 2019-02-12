package com.homework.threadlocal;

public class Person {

    private String name = "张三";

    public Person(String name) {
        this.name = name;
    }   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
