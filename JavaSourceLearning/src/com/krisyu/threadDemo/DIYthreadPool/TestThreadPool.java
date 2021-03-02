package com.krisyu.threadDemo.DIYthreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Kris
 * @Date: 2021/1/11 - 01 - 11 - 19:19
 * @Description: com.krisyu.threadDemo.threadPool
 * @version: 1.0
 */
public class TestThreadPool {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(2);
        UserThreadFactory f1 = new UserThreadFactory("第一机房");
        UserThreadFactory f2 = new UserThreadFactory("第二机房");

        UserRejectedHandler handler = new UserRejectedHandler();

        // 创建核心线程数为1，最大线程数为2， 阻塞队列长度为2，空闲时间为60秒，
        // 自定义ThreadFactory、RejectedHandler的线程池
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1,
                3,
                60,
                TimeUnit.SECONDS,
                queue, f1, handler);
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1,
                3,
                60,
                TimeUnit.SECONDS,
                queue, f2, handler);

        // 创建200个线程
        Runnable task = new UserThreadFactory.Task();
        for(int i=0; i<100; i++){
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
        threadPoolFirst.shutdown();
        threadPoolSecond.shutdown();

    }
}
