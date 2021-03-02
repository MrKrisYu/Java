package com.krisyu.forTest;

/**
 * @Author: Kris
 * @Date: 2021/1/8 - 01 - 08 - 19:45
 * @Description: com.krisyu.threadDemo
 * @version: 1.0
 */
public class Base {
    int w,x,y,z;
     public Base(int a, int b){
         x=a;y=b;
     }
    public Base(int a, int b,int c, int d){
        this(a,b); // new Base(a,b);
        w=d;z=c;
    }
}
