package com.krisyu.threadDemo.ProCus;

/**
 * @Author: Kris
 * @Date: 2021/1/8 - 01 - 08 - 17:31
 * @Description: com.krisyu.threadDemo.ProCus
 * @version: 1.0
 */
public class Good {
    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String kind) {
        Kind = kind;
    }

    private String Brand ;
    private String Kind ;
    private boolean mutex = false; // true表示有商品

    public synchronized void set(String brand, String kind){
        // 有商品时，生产者停止生产，直到商品被取走
        if(mutex){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setBrand(brand);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setKind(kind);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产者生产了商品" + this.Kind + " " + this.Brand);
        mutex = true;
        notify();
    }

    public synchronized void get(){
        // 若没有商品，则使使用消费者进程处于阻塞状态
        if(!mutex){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者取走了商品" + this.Kind + " " + this.Brand);
        this.Brand = null;
        this.Kind = null;
        mutex = false; // 取完一件后，就没有商品了
        notify();
    }
}
