package com.krisyu.threadDemo;

/**
 * @Author: Kris
 * @Date: 2021/1/8 - 01 - 08 - 16:29
 * @Description: com.krisyu.threadDemo
 * @version: 1.0
 */
public class RunnableDemo implements Runnable{
        @Override
    public void run() {
        for(int i=10; i>=1; i--){
            System.out.println(Thread.currentThread().getName() +
                    "---> count = "+i);
            try {
                Thread.sleep(1050);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
