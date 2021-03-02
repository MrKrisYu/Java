package com.krisyu.threadDemo.ProCus;

/**
 * @Author: Kris
 * @Date: 2021/1/8 - 01 - 08 - 17:47
 * @Description: com.krisyu.threadDemo.ProCus
 * @version: 1.0
 */
public class TestProdCus {
    public static void main(String[] args) {
        Good good = new Good();
        Produce produce = new Produce(good);
        Customer customer = new Customer(good);
        Thread threadPro = new Thread(produce,"Producer");
        Thread threadCus = new Thread(customer,"Customer");
        threadPro.start();
        threadCus.start();
    }
}
