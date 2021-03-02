package com.krisyu.genericity;

/**
 * @Author: Kris
 * @Date: 2021/1/4 - 01 - 04 - 21:25
 * @Description: com.krisyu.genericity
 * @version: 1.0
 */
public class TestGenericity {
    public static void main(String[] args) {
        GenericityMethod method = new GenericityMethod();
        method.method1(123);
        method.method1("123");
    }
}
