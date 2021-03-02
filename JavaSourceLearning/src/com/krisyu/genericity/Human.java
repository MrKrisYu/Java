package com.krisyu.genericity;

/**
 * @Author: Kris
 * @Date: 2021/1/4 - 01 - 04 - 21:23
 * @Description: com.krisyu.genericity
 * @version: 1.0
 */
public class Human<String> implements ParentGenericity<String>{
    public int age;
    public String name;


    @Override
    public String show(String s) {
        return null;
    }
}
