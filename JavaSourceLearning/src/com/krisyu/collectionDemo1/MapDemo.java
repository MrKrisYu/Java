package com.krisyu.collectionDemo1;

import java.util.HashMap;
import java.util.Queue;


public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("num",123);
        map.put("num2",345);
        System.out.println(map.entrySet());

    }
}
