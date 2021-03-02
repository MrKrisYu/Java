package com.krisyu.threadDemo.DIYthreadPool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: Kris
 * @Date: 2021/1/11 - 01 - 11 - 19:23
 * @Description: com.krisyu.threadDemo.threadPool
 * @version: 1.0
 */
public class UserThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String WhatFeatureOfGroup) {
        this.namePrefix = "UserThreadFactory-" + WhatFeatureOfGroup
        + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }

    static class Task implements Runnable{
        private final AtomicLong count = new AtomicLong(0L);
        @Override
        public void run() {
            System.out.println("running_" + count.getAndIncrement());
        }
    }
}


