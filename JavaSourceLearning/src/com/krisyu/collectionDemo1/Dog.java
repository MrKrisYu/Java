package com.krisyu.collectionDemo1;

import java.util.Objects;

/**
 * @Author: Kris
 * @Date: 2021/1/4 - 01 - 04 - 19:35
 * @Description: com.krisyu.collectionDemo1
 * @version: 1.0
 */
public class Dog {
    public int age ; // age
    public String name; // name

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age &&
                name.equals(dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
