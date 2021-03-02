package com.krisyu.threadDemo.ThreadPoolTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: Kris
 * @Date: 2021/1/11 - 01 - 11 - 22:55
 * @Description: com.krisyu.threadDemo.ThreadPoolTest
 * @version: 1.0
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Runnable task = new Task();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.schedule(task, 1, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis());
//        service.shutdown();
    }

    static class Task implements Runnable{
        private final AtomicLong count = new AtomicLong(0L);

        @Override
        public void run() {
            System.out.println("running_" + count.getAndIncrement());
            System.out.println(System.currentTimeMillis());
        }
    }
}
