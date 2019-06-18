package com.homework.entity;

public class ClassA implements Cloneable {

    private String classNameA = "A";
    
    private ClassB B = new ClassB();

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public String getClassNameA() {
        return classNameA;
    }

    public void setClassNameA(String classNameA) {
        this.classNameA = classNameA;
    }

    public ClassB getB() {
        return B;
    }

    public void setB(ClassB b) {
        B = b;
    }
    
}
