package com.krisyu.collectionDemo1;

import java.util.*;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 15:16
 * @Description: com.krisyu.collectionDemo1
 * @version: 1.0
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("132222");
        list.add("41111");
        list.add("2222");
        list.add("322");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.fill(list, "fill");
        System.out.println(list);
    }
}
