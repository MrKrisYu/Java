package com.krisyu.IODemo;

import java.io.Serializable;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 22:19
 * @Description: com.krisyu.IODemo
 * @version: 1.0
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 5652639225047565515L;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private transient int age ; // age
    private String name ; // name

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
