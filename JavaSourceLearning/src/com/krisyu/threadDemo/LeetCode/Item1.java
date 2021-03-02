package com.krisyu.threadDemo.LeetCode;

import java.util.Scanner;

/**
 * @Author: Kris
 * @Date: 2021/2/1 - 02 - 01 - 9:57
 * @Description: com.krisyu.threadDemo.LeetCode
 * @version: 1.0
 */
public class Item1 {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] chars = str.toCharArray();
        for(int i=1; i<str.length(); i = i+2){
            char c = chars[i];
            switch(c){
                case '1':first(()->System.out.print("first")); break;
                case '2':second(()->System.out.print("second")); break;
                case '3':third(()->System.out.print("third")); break;
                default:break;
            }
        }

    }

    public static void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public static void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public static void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
