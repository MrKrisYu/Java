package com.krisyu.threadDemo.threadLocalDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Kris
 * @Date: 2021/1/12 - 01 - 12 - 17:26
 * @Description: com.krisyu.threadDemo.threadLocalDemo
 * @version: 1.0
 */
public class IndependentCopyTest {
    static final ThreadLocal<String> threadParam = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        //死循环,测多几次看结果
        while (true) {
            //线程1
            new Thread(() -> {
                //设置参数
                threadParam.set("abc");
                //输出参数
                System.out.println("t1:" + threadParam.get());
                //看起来像是多余操作
//                threadParam.remove();
            }).start();
            TimeUnit.SECONDS.sleep(1);
            new Thread(() -> {
                //线程二,测试是否能获取abc
                System.out.println("t2:" + threadParam.get());
            }).start();
        }
    }
}