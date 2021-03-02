package com.krisyu.reflect;

/**
 * @Author: Kris
 * @Date: 2021/2/27 - 02 - 27 - 13:00
 * @Description: com.krisyu.reflect
 * @version: 1.0
 */
public class Person {
    private String name;
    private int id;

    public Person(){

    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
