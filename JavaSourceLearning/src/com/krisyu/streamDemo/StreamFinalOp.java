package com.krisyu.streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: Kris
 * @Date: 2021/1/19 - 01 - 19 - 20:09
 * @Description: com.krisyu.streamDemo
 * @version: 1.0
 */
public class StreamFinalOp {
    static void func_find(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();
//        Optional<Integer> op1  = stream.findAny();
        Optional<Integer> op1  = stream.findAny();
        System.out.println(op1.get());

    }
    static void func_reduce(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();
//        Optional<Integer> op1  = stream.findAny();
        Integer result  = stream.peek(x -> System.out.println(x + " is operating")).reduce(1, Integer::sum);
        System.out.println(result);

    }

    public static void main(String[] args) {
        func_reduce();
    }
}
