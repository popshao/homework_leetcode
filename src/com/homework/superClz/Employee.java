package com.homework.superClz;

public class Employee {

    private String name;
    
    private Integer age;
    
    private String phone;
    
    private String address;

    public Employee() {
        System.out.println(111);
    }
    
    public Employee(String name) {
        System.out.println(222);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
