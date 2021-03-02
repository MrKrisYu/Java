package com.krisyu.Enum_Date_Demo;

/**
 * @Author: Kris
 * @Date: 2021/1/4 - 01 - 04 - 15:21
 * @Description: com.krisyu.collectionDemo
 * @version: 1.0
 */
public class TestEnum {
    public static void main(String[] args) {
//       Season spring = Season.SPRING;
//       System.out.println(spring.getName());
//       spring.setName("修改了的春天");
//       System.out.println(spring.getName());
//        for(Day day : Day.values()){
//            System.out.println(day.ordinal() + "--> " + day.name() + ": " + day.getDay());
//        }
        for(Color c: Color.values()){
            System.out.println(c.ordinal() + "-->" +c.name() + ": " +c.getColor());
        }
    }
}
