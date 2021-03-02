package com.krisyu.streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: Kris
 * @Date: 2021/1/15 - 01 - 15 - 23:01
 * @Description: com.krisyu.streamDemo
 * @version: 1.0
 */
public class StreamGeneration {
    static void func1(){
        String[] strs  = {"a", "d", "c", "f", "e"};
        Stream<String> str1 = Stream.of(strs); // of(T... values):返回其元素是指定值的顺序排序流。
        str1.forEach(System.out::print);
    }
    static void func2(){
        List<String> list = Arrays.asList("1","2","4","3");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::print);
    }
    static void func3(){
        Stream<Integer> generate = Stream.generate(()->1)
                                         .limit(10);
        generate.forEach(System.out::print);
    }
    static void func4(){
        Stream<Integer> iterate = Stream.iterate(1, x->x+1)
                                        .limit(10);
        iterate.forEach(System.out::print);
    }

    public static void main(String[] args) {
        func4();
    }
}
