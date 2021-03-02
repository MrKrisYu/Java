package com.krisyu.threadDemo.DIYthreadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
* @Author: Kris
* @Date: 2021/1/11 - 01 - 11 - 19:29
* @Description: com.krisyu.threadDemo.threadPool
* @version: 1.0
*/

public class UserRejectedHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected. " + executor.toString());
    }
}
