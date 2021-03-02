package com.krisyu.threadDemo.threadLocalDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: Kris
 * @Date: 2021/1/12 - 01 - 12 - 16:54
 * @Description: com.krisyu.threadDemo
 * @version: 1.0
 */
public class ThreadLocalTest {
//    private static final ThreadLocal<String> THREAD_LOCAL_TAG = new ThreadLocal<String>(){
//        @Override
//        protected String initialValue(){
//            return "ThreadLocal默认值";
//        }
//    };
        private static final ThreadLocal<String> THREAD_LOCAL_TAG = new ThreadLocal<String>();

    private static class Player implements Runnable{
        private final AtomicLong count = new AtomicLong(1L);
        @Override
        public void run() {
            long nextId = count.getAndIncrement();
            THREAD_LOCAL_TAG.set(Long.toString(nextId));
            String defualt_value = Thread.currentThread().getName() + "-->"+nextId +
                    ": "+ THREAD_LOCAL_TAG.get();
            System.out.println(defualt_value);
            THREAD_LOCAL_TAG.remove();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Runnable task = new Player();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i=0; i<10; i++){
            service.execute(task);
        }
        service.shutdown();
    }

}
