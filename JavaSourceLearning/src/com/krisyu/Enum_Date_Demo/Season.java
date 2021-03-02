package com.krisyu.Enum_Date_Demo;

/**
 * @Author: Kris
 * @Date: 2021/1/4 - 01 - 04 - 15:21
 * @Description: com.krisyu.collectionDemo
 * @version: 1.0
 */
public enum Season {
    SPRING("春天"),SUMMER("夏天"),
    AUTUMN("秋天"),WINTER("冬天"); // 枚举类型的元素，每个元素中有个字符串属性
    private  String name; // 即括号中的字符串，如SPRING中的春天

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    Season(String name){ // 构造方法不能是public，枚举的构造方法是内部的静态方法
        this.name = name;
    }
}
