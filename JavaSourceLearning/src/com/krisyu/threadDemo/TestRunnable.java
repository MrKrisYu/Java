package com.krisyu.threadDemo;

/**
 * @Author: Kris
 * @Date: 2021/1/8 - 01 - 08 - 16:29
 * @Description: com.krisyu.threadDemo
 * @version: 1.0
 */
public class TestRunnable implements Runnable{
    public static void main(String[] args) {
        Thread threadA = new Thread(new TestRunnable(), "Main");
        Thread threadB = new Thread(new RunnableDemo(), "Thread1");
        threadA.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.NORM_PRIORITY);
        threadA.start();
        threadB.start();
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++){
            System.out.println(Thread.currentThread().getName() +
                    "---> count = "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
