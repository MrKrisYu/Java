package com.krisyu.forTest;

/**
 * @Author: Kris
 * @Date: 2021/1/9 - 01 - 09 - 12:44
 * @Description: com.krisyu.threadDemo.forExam
 * @version: 1.0
 */
public class FloatTrap {
    public static void main(String[] args) {
        float a = 0.9f-0.8f;
        float b = 1.0f-0.9f;
        float eps = 1e-7f;
        System.out.print("float: a==b ? --->");
        float epsA_B = Math.abs(a-b);
        System.out.println(epsA_B);
        System.out.println(eps);
        if(Math.abs(a-b) < eps){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        Float m = Float.valueOf(a);
        Float n = Float.valueOf(b);
        System.out.print("Float: a==b ? --->");
        if(m.equals(n)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println(m);
        System.out.println(n);

        Double x = new Double(a);
        Double y = new Double(b);
        System.out.print("Double: a==b ? --->");
        if(x.equals(y)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println(x);
        System.out.println(y);
    }
}
