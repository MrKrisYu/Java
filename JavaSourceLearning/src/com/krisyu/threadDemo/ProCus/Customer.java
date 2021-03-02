package com.krisyu.threadDemo.ProCus;

/**
 * @Author: Kris
 * @Date: 2021/1/8 - 01 - 08 - 17:24
 * @Description: com.krisyu.threadDemo.ProCus
 * @version: 1.0
 */
public class Customer implements Runnable{
    private Good good;

    public Customer(Good good) {
        this.good = good;
    }


    @Override
    public void run() {
        for(int i=0; i<10; i++){
            good.get();
        }
    }
}
