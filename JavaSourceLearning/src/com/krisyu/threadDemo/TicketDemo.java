package com.krisyu.threadDemo;

/**
 * @Author: Kris
 * @Date: 2021/1/8 - 01 - 08 - 17:02
 * @Description: com.krisyu.threadDemo
 * @version: 1.0
 */
public class TicketDemo implements Runnable{
    private int ticket = 5;
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() +
                            "正在售卖票，还剩票数" + ticket-- );
                }
                if(ticket == 0) break;
            }
        }
    }

    public static void main(String[] args) {
        TicketDemo ticket = new TicketDemo();
        Thread a = new Thread(ticket, "A");
        Thread b = new Thread(ticket, "B");
        Thread c = new Thread(ticket, "C");
        Thread d = new Thread(ticket, "D");
        Thread e = new Thread(ticket, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}
