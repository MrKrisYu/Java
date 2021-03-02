package com.krisyu.streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: Kris
 * @Date: 2021/1/15 - 01 - 15 - 23:37
 * @Description: com.krisyu.streamDemo
 * @version: 1.0
 */
public class StreamMidOperation {
    static void func_filter(){
        final String func_name = "func_filter"; //MethodName for print
        Stream<Integer> stream1 = Stream
                .iterate(1, x->x+1)
                .limit(10)
                .filter(x -> x%2 == 1); // 滤除偶数
        System.out.println("After " + func_name + " operates: ");
        stream1.forEach(x -> System.out.print(x + " "));
    }
    static void func_distinct(){
        final String func_name = "func_distinct"; //MethodName for print
        Stream<Integer> stream2 = Stream
                .iterate(1, x->x)
                .limit(10)
                .distinct(); // 滤除偶数
        System.out.println("After " + func_name + " operates: ");
        stream2.forEach(x -> System.out.print(x + " "));
    }
    static void func_sorted(){
        final String func_name = "func_sorted"; //MethodName for print
        List<String> list = Arrays.asList("1","2","4","3","8","-1");
        Stream<String> stream2 = list.stream().sorted();
        System.out.println("After " + func_name + " operates: ");
        stream2.forEach(x -> System.out.print(x + " "));
    }
    static void func_skip(){
        final String func_name = "func_skip"; //MethodName for print
        Stream<Integer> stream3 = Stream
                .iterate(1, x->x+1)
                .limit(10)
                .peek( x -> System.out.println(x + " is filtered"))
                .skip(5);
        System.out.println("After " + func_name + " operates: ");
        stream3.forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        Stream<Integer> stream = Stream
                .iterate(1, x->x)
                .limit(10);
        System.out.println("Generate Stream as following: ");
        stream.forEach(x -> System.out.print(x + " "));
        System.out.println();

//        func_filter();
//        func_distinct();
//        func_sorted();
        func_skip();
    }
}
