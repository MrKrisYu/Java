package com.krisyu.threadDemo.threadLocalDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Kris
 * @Date: 2021/1/12 - 01 - 12 - 17:29
 * @Description: com.krisyu.threadDemo.threadLocalDemo
 * @version: 1.0
 */
public class IssueOfUsingThreadPoll {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

        Thread threadA = new Thread(()->{
            stringThreadLocal.set("OnlyThreadAOwnMe!");
            System.out.println("ThreadA -->"+stringThreadLocal.get());
            stringThreadLocal.remove();
        });
        Thread threadB = new Thread(()->{
            System.out.println("ThreadB -->"+stringThreadLocal.get());
            stringThreadLocal.remove();
        });

        while(true){
            threadPool.execute(threadA);
            threadPool.execute(threadB);
        }

    }
}
