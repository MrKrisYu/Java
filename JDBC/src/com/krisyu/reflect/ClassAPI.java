package com.krisyu.reflect;

import java.lang.reflect.Field;

/**
 * @Author: Kris
 * @Date: 2021/2/27 - 02 - 27 - 12:59
 * @Description: com.krisyu.reflect
 * @version: 1.0
 */
public class ClassAPI {
    public static void main (String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.krisyu.reflect.Person");

        // 获取成员变量
        Field[] fields = clazz.getFields();
        for(Field field: fields){
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
    }
}
