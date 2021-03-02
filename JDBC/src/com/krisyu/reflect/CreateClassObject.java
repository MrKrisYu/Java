package com.krisyu.reflect;

import com.krisyu.entity.Emp;

/**
 * @Author: Kris
 * @Date: 2021/2/26 - 02 - 26 - 16:41
 * @Description: com.krisyu.reflect
 * @version: 1.0
 */
public class CreateClassObject {

    public static void main(String[] args) throws Exception{
        // 1. 通过class.forname()来获取Class对象(推荐)
        Class clazz = Class.forName("com.krisyu.entity.Emp");
        System.out.println(clazz.getPackage());
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName()); // 符合Java类名规范的字符串

        // 2. 过类名来获取
        Class<Emp> empClazz = Emp.class;
        // 3. 通过对象的getClass()来获取（不推荐）
//        Class clazz1 = new Emp().getClass();

        // 4. 基本数据类型可以通过TYPE
        Class<Integer> integerClass = Integer.TYPE;
        System.out.println(integerClass.getCanonicalName());
        System.out.println(integerClass.getName());
    }
}
